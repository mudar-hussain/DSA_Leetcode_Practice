class Solution {
    public int minSwaps(int[] nums) {
        int k = Arrays.stream(nums).sum();
        int n = nums.length;
        int count = 0;
        for(int i = 0; i<k; i++) {
            count += nums[i];
        }
        int maxCount = count;
        for(int i = k; i<k+n; i++) {
            count += nums[i%n];
            count -= nums[(i-k+n)%n];
            maxCount = Math.max(maxCount, count);
        }        
        return k-maxCount;
    }
}