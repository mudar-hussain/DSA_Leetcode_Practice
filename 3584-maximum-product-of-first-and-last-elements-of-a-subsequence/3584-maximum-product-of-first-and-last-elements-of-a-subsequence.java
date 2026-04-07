class Solution {
    public long maximumProduct(int[] nums, int m) {
        int n = nums.length;
        long res = Long.MIN_VALUE;
        int minVal = Integer.MAX_VALUE;
        int maxVal = Integer.MIN_VALUE;
        for(int i = 0; i<n-m+1; i++){
            minVal = Math.min(minVal, nums[i]);
            maxVal = Math.max(maxVal, nums[i]);
            int j = i+m-1;
            // for(int j = i+m-1; j<n; j++) {
                long num = nums[j];
                res = Math.max(res, minVal*num);
                res = Math.max(res, maxVal*num);
            // }
        }
        return res;
        
    }
}