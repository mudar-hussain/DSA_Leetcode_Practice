class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        long product = 1;
        int left = 0;
        for(int i = 0; i<nums.length; i++) {
            product = product * (long)nums[i];
            while(left<=i && product >= (long)k) {
                product = product / (long)nums[left++];
            }
            if(product<(long)k) count += i-left+1;
        }
        return count;
    }
}