class Solution {
    private boolean isValid(int[] weights, long target, int days) {
        int count = 1;
        long wt = 0;
        for(int i: weights) {
            if(wt+i > target){
                count++;
                wt = 0;
            }
            wt += i;
        }
        return count<=days;

    }
    public int shipWithinDays(int[] weights, int days) {
        long low = 0, high = 0;
        for(int i: weights) {
            low = Math.max(low, i);
            high += i;
        }
        while(low<high) {
            long mid = low + (high-low)/2;
            if(isValid(weights, mid, days)) high = mid;
            else low = mid + 1;
        }
        return (int) high;
    }
}