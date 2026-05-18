class Solution {
    public int mySqrt(int x) {
        if(x==0 || x==1) return x;
        int low = 1, high = x;
        int mid = -1;
        while(low<=high){
            mid = low + (high-low)/2;
            if((long)mid*mid>(long)x) high = mid-1;
            else if(mid*mid==x) return mid;
            else low = mid+1;
        }
        return Math.round(high);
    }
}