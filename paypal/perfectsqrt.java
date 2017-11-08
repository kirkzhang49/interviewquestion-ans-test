class Solution {
    public boolean isPerfectSquare(int num) {
        int low =0,high = num;
        while(low<=high){
            long mid = (low+high)>>>1;//use low for over flow
            if (mid*mid==num) return true;
           else if (mid*mid<num) low =(int)mid+1;
            else high = (int) mid-1;
        }
        return false;
    }
}
