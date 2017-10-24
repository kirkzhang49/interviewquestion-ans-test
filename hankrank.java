 static int[] oddNumbers(int l, int r) {
            List<Integer> list = new ArrayList<>();
        while (l<=r)
        {
            if(l%2!=0)
                list.add(l);
            l++;
        }
        int [] result = new int[list.size()];
        for (int i=0;i<list.size();i++)
            result[i] = list.get(i);
        return result;

    }


    static String findNumber(int[] arr, int k) {
     String ss1="YES",ss2="NO";
            for (int i=0;i<arr.length;i++)
            {
                if (arr[i]==k)return ss1;
            }
        return ss2;

    }

    /*
 * Complete the function below.
 */

    static String getShiftedString(String s, int left, int right) {
                if(s.length()<=1) return s;
            
        String result ="";
        result = shiftleft(s,left);
        result = shiftright(result,right);
        return result;
    }
public static String shiftleft(String s,int k)
{
    String result = "";
    /*for (int i=0;i<k;i++)
        result = result.substring(1) + result.charAt(0);*/
    int n = k%s.length();
    result = s.substring(n) + s.substring(0,n);
    return result;
}
public static String shiftright(String s,int k)
{
     String result = s;
    for (int i=0;i<k;i++)
        result = result.charAt(result.length()-1) + result.substring(0,result.length()-1);
    return result;
}

/*
 * Complete the function below.
 */

    static long count(int[] numbers, int k) {
         long dd =0;
        int temp=0;
        HashSet<Integer> check =new HashSet<>();
        for (int i=0;i<numbers.length;i++)
        {
             if (numbers[i]<k) dd++;
            check.add(numbers[i]);
            for (int j=i+1;j<numbers.length;j++)
            {
                if (j==i+1) temp = numbers[i]*numbers[j];
                else temp *= numbers[j];
                if (temp<k&&!check.contains(temp)) dd++;
            }
        }
       /* for (int i=0;i<numbers.length;i++)
        {
           
        }*/
       
        return dd;

    }

