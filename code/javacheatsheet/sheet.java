 
 
 HashMap<Integer,Integer> map = new HashMap<Integer,Integer>(); //hashmap declaration
    
    if (map.containsKey(nums2[i])) //map containsKey
            {
                map.put(nums2[i],map.get(nums2[i])-1);
                if (map.get(nums2[i])==0)
                   map.remove(nums2[i]);
                result.add(nums2[i]);
            }// map get,put,remove useage
    
     int [] res = new int[result.size()]; // [] array declaration
         for (int i =0;i<res.length;i++)
        {
            res[i] = result.get(i);
        }//translate

HashSet<Integer> Set = new HashSet<Integer>();//HashSet declaration
Set.contains(nums2[i]) //Set contains 
Set.remove(nums2[i]);//Set remove

 char []result = s.toCharArray();//convert string to char Array

  String[] parts = s.trim().split("\\s+");//.trim() for all leading space 
  //.split("\\s+") for all spaces
  return new String(result);//char [] become String

  ArrayList<V> valuesList = new ArrayList<V>(hashMap.values());
  //arraylist from hashMap.values 

  Map<String, Character> myNewHashMap = new HashMap<>();
for(Map.Entry<Character, String> entry : myHashMap.entrySet()){
    myNewHashMap.put(entry.getValue(), entry.getKey());
}//reverse key and value in map  entrySet is the every elements in map
  
   Deque<Integer> stack = new ArrayDeque <Integer>(); //deque declaration last in frist out
 PriorityQueue<Integer> pq = new PriorityQueue<>();// PriorityQueue declaration 
    for(int val : nums) {
        pq.offer(val);//add val

        if(pq.size() > k) { //poll will remove min one first
            pq.poll();//if more than k remove min one
        }
    }
    return pq.peek();//min one

     Stack<Character> strings = new Stack<Character>();
     strings.push(s.charAt(i));//last in first out declaration  
    if (s.charAt(i) == '}') {//usage
    if (strings.isEmpty() || strings.pop() != '{') {
        return false;

    Queue<TreeNode> q = new LinkedList<>(); // first in first out 
    TreeNode node = q.poll(); // poll out first in 
    q.offer(node.left);//add to last
    int a =1;
    char b = (char) a;// int to char 
    List<List<Integer>> result = new ArrayList<>();//List declaration
     Arrays.sort(nums);//sort the int []
<<<<<<< HEAD
     public boolean isAnagram(String s, String t) {
        char [] check1 = s.toCharArray();
        char [] check2 = t.toCharArray();//string to char array
        Arrays.sort(check1);
        Arrays.sort(check2);//sort [] array 
        return (new String(check1).equals(new String(check2)));// string compare method
    }
        int[] alphabet = new int[26];//26 letters
        for (int i = 0; i < s.length(); i++) alphabet[s.charAt(i) - 'a']++;//'a' to make it to range
        for (int i = 0; i < t.length(); i++) alphabet[t.charAt(i) - 'a']--;//loop to cancel each other
        for (int i : alphabet) if (i != 0) return false;//if one of alphabet not canceled return false;
        return true;

         if (Math.abs(len1-len2)>1||s.equals(t)) return false;// equals  use to  compare two string 
         if (s.charAt(i)!=t.charAt(j))//char position at string 
           char [] chars = s.toCharArray();// string to char
           return new String(chars); // char to string
            String [] ss = s.split("\\s+");//split by all spaces 
        StringBuilder sb = new StringBuilder();//declear StringBuilder
        for (int i = ss.length-1;i>=0;i--)
        {
            sb.append(ss[i]+" ");//StringBuilder append
        }
        return sb.toString().trim();//remove leading and ending space
         return String.join(" ",ss);//join String [] to String by split by space 
     Queue<String> maxheap = new PriorityQueue<>((x,y)->name_speed.get(y)-name_speed.get(x));
     maxheap.addAll(name_speed.KeySet());//add all key set to maxheap
 //but priorityqueue define use their get value to compare 
 //max will be first 
 _________________________________
 //array declaration
 String [] file1 = new String []
     {
         "d1, 30",
         "d2, 40",
         "d3, 30"
     };
=======

      public void recur(List<List<String>> res,List<String> temp, String s){
        if(s.length()==0){
            res.add(new ArrayList<String>(temp));//tem is List<String> put into new ArrayList
_____________________________________________
return new int [] {i,map.get(target-nums[i])};//return  [] int 