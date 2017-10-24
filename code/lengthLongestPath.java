public class Solution {
    public int lengthLongestPath(String input) {
        Deque<Integer> stack = new ArrayDeque <Integer>();
        stack.push(0);
        //dummy
        int maxlength = 0;
        for (String s : input.split("\n"))
        {
            int level = s.lastIndexOf("\t")+1;//number of \t  +1 for last \
            while (level+1<stack.size())
            stack.pop();//pop all path until level + 1 = stack.size
            int len = stack.peek()+s.length()-level +1;//parent's path length + s.length - \t + one more \
            stack.push(len); // save this path
            if (s.contains("."))
            {
                maxlength = Math.max(maxlength,len-1);//- 1 for remove one \
            }
        }
        return maxlength;
    }
}