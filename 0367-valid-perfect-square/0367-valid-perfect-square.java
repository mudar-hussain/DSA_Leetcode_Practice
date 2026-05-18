class Solution {
    public boolean isPerfectSquare(int num) {
        if(num == 0 || num == 1) return true;
        int low = 1, high = num;
        while(low<=high) {
            int mid = low + (high - low)/2;
            if((long)mid * mid < (long)num) low = mid+1;
            else if(mid*mid == num) return true;
            else high = mid-1;
        }
        return false;
    }
}