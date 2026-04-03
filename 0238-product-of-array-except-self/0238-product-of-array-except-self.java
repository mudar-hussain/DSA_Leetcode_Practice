class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int[] res = new int[n];
        int product = 1;
        for(int i = 0; i<n; i++) {
            product *= nums[i];
            prefix[i] = product;
        }
        product = 1;
        for(int i = n-1; i>=0; i--) {
            product *= nums[i];
            suffix[i] = product;
        }
        for(int i = 0; i<n; i++){
            int left = i>0?prefix[i-1]:1;
            int right = i<n-1?suffix[i+1]:1;
            res[i] = left*right;
        }
        return res;
        
    }
}