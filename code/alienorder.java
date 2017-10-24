public String alienOrder(String [] words)
{
    Map<Character,Set<Character>> map = new HashMap<Character,Set<Character>>();
    Map<Character,Integer> degree = new HashMap<Character,Integer>();
    String result = "";
    if (words==null||words.length==0)
    return result;
    for (String s : words)
    {
        for (char c :s.toCharArray())
        {
            degree.put(c,0);//inital character exist in words with 0
        }
    }
    for (int i=0;i<words.length-1;i++)
    {
        String current = words[i];//first words
        String next = words[i+1];//next words
        int length = Math.min(current.length(),next.length());
        for (int j=0;j<length;j++)
        {
            char c1=current.charAt(j);
            char c2=next.charAt(j);
            if (c1!=c2)
            {
                Set<Character> set = new HashSet<Character>();
                if (map.containsKey(c1))
                  set=map.get(c1);// if exist c1 in map inital with it
            if (!set.contains(c2))
            {
                 set.add(c2);
                 map.put(c1,set);//the set which after c1
                 degree.put(c2,degree.get(c2)+1); //after add a degree
            }
            break;
            }
        }
    
    Queue<Character> q = new LinkedList<Character>();
    for (char c : degree.KeySet())
    {
       if (degree.get(c)==0)
       q.add(c);//first degree first!
    }
    while (!q.isEmpty())
    {
        char c = q.remove();
        result +=c;
        if (map.containsKey(c))
        {
            for (char c2 :map.get(c))
         {
           degree.put(c2,degree.get(c2)-1);
           if (degree.get(c2)==0)
           q.add(c2); //add the follower of first q into queue 
        }
        }
    }
}
    if (result.length()!=degree.size())
    return "";
    return result;
}


public class Solution {
   public String alienOrder(String[] words) {
		if (words == null || words.length == 0) {
			return "";
		}

		// find the number of keys
		Map<Character, Integer> dependencyLevel = new HashMap<Character, Integer>();
		for (String word : words) {
			for (char ch : word.toCharArray()) {
				dependencyLevel.put(ch, 0);
			}
		}

		// create graph
		Map<Character, Set<Character>> graph = new HashMap<Character, Set<Character>>();
		for (int i = 0; i < words.length - 1; i++) {
			String currentWord = words[i];
			String nextWord = words[i + 1];

			// compare two string at a time to find character level dependency
			int length = Math.min(currentWord.length(), nextWord.length());
			boolean missMatchFound = false;
			for (int j = 0; j < length; j++) {
				char ch1 = currentWord.charAt(j);
				char ch2 = nextWord.charAt(j);

				// if both are same then they have same level of dependency
				if (ch1 == ch2) {
					continue;
				}

				Set<Character> indegreeNodes = new HashSet<Character>();
				if (graph.containsKey(ch1)) {
					indegreeNodes = graph.get(ch1);
				}

				// updating dependency level of c2 by + 1
				if (indegreeNodes.add(ch2)) {
					graph.put(ch1, indegreeNodes);
					dependencyLevel.put(ch2, dependencyLevel.get(ch2) + 1);
				}

				// need to break at the first mismatch character as the above
				// comparison is valid only if all the previous characters are
				// matching
				// characters.
				missMatchFound = true;
				break;
			}

			// handling the situation when (1) = abceeee and (2) = abc. In this
			// situation the input order is invalid
			if (!missMatchFound && currentWord.length() > nextWord.length()) {
				return "";
			}
		}

		// fetching all 0 level dependency characters
		Queue<Character> queue = new LinkedList<Character>();
		for (char ch : dependencyLevel.keySet()) {
			if (dependencyLevel.get(ch) == 0) {
				queue.add(ch);
			}
		}

		StringBuilder sb = new StringBuilder();
		// performing topology sort
		while (!queue.isEmpty()) {
			char ch = queue.remove();
			sb.append(ch);
			if (graph.containsKey(ch)) {
				for (char indegreeNodes : graph.get(ch)) {
					// updated dependency by -1
					dependencyLevel.put(indegreeNodes, dependencyLevel.get(indegreeNodes) - 1);
					
					if (dependencyLevel.get(indegreeNodes) == 0) {
						queue.add(indegreeNodes);
					}
				}
			}
		}

		if (sb.length() != dependencyLevel.size()) {
			return "";
		}

		return sb.toString();
	}
}