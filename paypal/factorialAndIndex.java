class Solution {
  public static void main(String[] args) {
        int result = factorial(3);
    System.out.print(result);
  }
  
  public static int factorial(int n)
  {
     if (n==0) return 1;
     else if (n==1) return 1;
    else return n*factorial(n-1);
  }
}

class Solution {
  public static void main(String[] args) {
        int result = factorial(5);
    System.out.print(result);
  }
  
  public static int factorial(int n)
  {
    int result =1;
     for (int i=1;i<=n;i++){
          result*=i;
     }
    return result;
  }
}

class Solution {//index of the number equal all other element sum together
  public static void main(String[] args) {//O(n^2)
      int [] nums = {1,2,3,5,5,-3,-2,-1,1,11};
    int result = IndexSum(nums);
    System.out.print(result);
  }
  
  public static int IndexSum(int [] nums)
  {
    int j=0,sum=0;
    while (true)
    {
      for (int i=0;i<nums.length;i++)
      {
         if (i!=j){
            sum+=nums[i];
         }
      }
      if (nums[j]==sum)
        return j;
      j++;
      if (j==nums.length)
        break;
      sum=0;
    }
    return -1;
 
  }
}

// CPP program to find all factorial numbers
// smaller than or equal to n.
#include <iostream>
using namespace std;
 
void printFactorialNums(int n)
{
    int fact = 1;
    int x = 2;
    while (fact <= n) {
        cout << fact << " ";
 
        // Compute next factorial 
        // using previous
        fact = fact * x;
 
        x++;
    }
}