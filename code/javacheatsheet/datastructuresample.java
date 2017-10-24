  public int firstBadVersion(int n) {
        int start =1, end = n;
        while (start<end)
        {//sample binary search
            int mid = start +(end - start)/2; //go middle
            if (!isBadVersion(mid)) start = mid+1;//if not it will happen latest
            else
             end = mid;// first happen before
        }
        return start;
    }