public int directorySolution(String s )
{
    int res = 0;
    if (s!=null && s.length()>0)
    {
        String [] lines = s.split("\n");
        Stack<String> stack = new Stack<String>();
     stack.push("");//root
     int curPathLen = 0;
     HashSet<String> containsFile = new HashSet<String>();
     for (int i = 0;i<lines.length;i++)
    }
    int indent = 0;
    while (indent<lines[i].length()&&lines[i].charAt(indent)==' ')
    {
        indent ++;
    }
    boolean isFile = lines[i].endswith(".txt")||lines[i].endswith(".png")||
    lines[i].endswith(".gif") ||lines[i].endswith("jpg");
    while (!stack.peek().equals(""))//at root level
    &&(stack.size()-1)*2 >indent)
    {
        // pop until stack peek level above current
        String folderAtsameLevel = stack.pop();
        current -= (folderAtsameLevel.length()+1);
    }
    if (!isFile)
    {
        stack.add(lines[i].trim());
        curPathLen += (lines[i].trim().length()+1);
    }
    else if (!containsFile(stack.peek()))
    {
        res += curPathLen;
        containsFile.add(stack.peek());
    }
    }
}
return res;
}