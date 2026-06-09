class Solution {
    private boolean isValid(int[] nums, int threshold, int divisor) {
        long sum = 0;
        for(int num: nums) {
            sum += (num + divisor - 1L) / divisor;
            if(sum>threshold) return false;
        }
        return true;
    }
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        int ans = high;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(isValid(nums, threshold, mid)){
                ans = mid;
                high = mid-1;
            } else 
                low = mid + 1;
        }
        return ans;
    }

}