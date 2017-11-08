
    /*
     * Complete the function below.
     */
    static int[] getMaxElementIndices(int[] a, int[] rotate) {
               ArrayList<Integer> result = new ArrayList<>();
                for (int i=0;i<rotate.length;i++)
                {
                    int [] temp = a.clone();
                    rotate(temp,rotate[i]);
                    int max = findMaxIndex(temp);
                    result.add(max);
                }
        
            int [] ans = new int[result.size()];
        
            for (int i=0;i<ans.length;i++)
            {
                ans[i] = result.get(i);
            }
            return ans;
    }
    public static int findMaxIndex(int [] num)
    {
        int index = 0, max = Integer.MIN_VALUE;
        for (int i=0;i<num.length;i++)
        {
            if (num[i]>max)
            {
                max = num[i];
                index = i;
            }
        }
        return index;
    }


  public static void rotate(int []num, int n)
    {
        n = n%num.length;
        reverse(num,0,num.length-1);
        reverse(num,0,n-1);
        reverse(num,n,num.length-1);
    }
    public static void reverse(int [] num,int left,int right)
    {
        while (left<right)
        {
            int temp = num[left];
            num[left] = num[right];
            num[right] =temp;
            left++;
            right--;
        }
    }
