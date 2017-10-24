public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        int len = s.length();
        boolean [] f = new boolean[len +1];
        f [0] = true;
        //dynamic programing
        for (int i=1;i<=len;i++)
        {
            for (int j=0;j<i;j++)
            {
                if (f[j]&&wordDict.contains(s.substring(j,i)))//if start from true
                {//and j to i is true exist a word
                f[i] = true;
                break; //if exist a word update table and break  
                }
            }
        }
        return f[len];
    }
}

public class Solution {
    public boolean wordBreak(String s, Set<String> dict) {
        
        boolean[] f = new boolean[s.length() + 1];
        
        f[0] = true;
        
        
        /* First DP
        for(int i = 1; i <= s.length(); i++){
            for(String str: dict){
                if(str.length() <= i){
                    if(f[i - str.length()]){
                        if(s.substring(i-str.length(), i).equals(str)){
                            f[i] = true;
                            break;
                        }
                    }
                }
            }
        }*/
        
        //Second DP
        for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && dict.contains(s.substring(j, i))){ //if from j to i is a word make f[i] = true
                    f[i] = true; // also f[j] need to be true so means before j there are one word or some words find 
                    break;//break it since get a word
                }
            }
        }
        
        return f[s.length()];//until last word true it is true
    }
}