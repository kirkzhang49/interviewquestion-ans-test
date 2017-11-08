
//expression (((1+3)-5)+9)
class Solution {
    public int calculate(String s) {
        int len = s.length(),sign=1,result=0,sum=0;
        Stack<Integer> stack = new Stack<>();
        for (int i=0;i<len;i++){
            if(Character.isDigit(s.charAt(i))){
                sum = s.charAt(i)-'0';
                while(i+1<len&&Character.isDigit(s.charAt(i+1))){
                   sum = sum*10 + s.charAt(i+1) -'0';
                    i++;
                }
                result +=sum*sign;
            }else if (s.charAt(i)=='+'){
                sign=1;
            }else if (s.charAt(i)=='-'){
                sign=-1;
            }else if (s.charAt(i)=='('){
                stack.push(result);
                stack.push(sign);
                result = 0;
                sign =1;
            }else if (s.charAt(i)==')'){
                result = stack.pop()*result+stack.pop();//previous last sign * current val + last result
            }
        }
        return result;
    }
}



// "123", 6 -> ["1+2+3", "1*2*3"] 
// "232", 8 -> ["2*3+2", "2+3*2"]
// "105", 5 -> ["1*0+5","10-5"]
// "00", 0 -> ["0+0", "0-0", "0*0"]
// "3456237490", 9191 -> []

class Solution {//
    public List<String> addOperators(String num, int target) {
        List<String> result = new ArrayList<>();
        if (num==null||num.length()==0) return result;
        helper(result,"",num,target,0,0,0);
        return result;
    }
    private void helper(List<String> result,String path, String num,int target,int pos,long eval,long multed)
    {
        if (pos==num.length())//all num string used
        {
            if (target==eval) result.add(path);//add path
            return;
        }
        for (int i=pos;i<num.length();i++)//read over all the string
        {
            if (i!=pos&&num.charAt(pos)=='0') break;//if pos = zero and i is not pos break zero can't be leading char
            long cur = Long.parseLong(num.substring(pos,i+1));//parse this part of number
            if (pos==0)//first initial number
            {
               helper(result,path+cur,num,target,i+1,cur,cur);//set up initial number of function
            }
            else
            {
                 helper(result,path+"+"+cur,num,target,i+1,eval+cur,cur);//multed as previous number
                 helper(result,path+"-"+cur,num,target,i+1,eval-cur,-cur);
                 helper(result,path+"*"+cur,num,target,i+1,eval-multed+cur*multed,multed*cur);//if * multed is priority since *first combine previous to this
            }
        }
    }
}

class Solution {// basic calculator
    public int calculate(String s) {
         if (s == null) return 0;
    s = s.trim().replaceAll(" +", "");
    int length = s.length();
    
    int res = 0;
    long preVal = 0; // initial preVal is 0
    char sign = '+'; // initial sign is +
    int i = 0;
    while (i < length) {
        long curVal = 0;
        while (i < length && (int)s.charAt(i) <= 57 && (int)s.charAt(i) >= 48) { // int value update unitl non int char 
            curVal = curVal*10 + (s.charAt(i) - '0');
            i++;
        }
        if (sign == '+') {
            res += preVal;  // update res add all before combine of */
            preVal = curVal;
        } else if (sign == '-') {
            res += preVal;  // update res
            preVal = -curVal;
        } else if (sign == '*') {
            preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
        } else if (sign == '/') {
            preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
        }
        if (i < length) { // getting new sign
            sign = s.charAt(i);
            i++;
        }
    }
    res += preVal;//finnally add it
    return res;
    }
}