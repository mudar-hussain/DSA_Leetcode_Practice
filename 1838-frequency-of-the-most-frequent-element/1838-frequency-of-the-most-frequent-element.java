class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 1, left = 0;
        long windowSum = 0;
        for(int right = 0; right<nums.length; right++) {
            windowSum += nums[right];
            while((long)nums[right]*(right-left+1) - windowSum > k) {
                windowSum -= nums[left];
                left++;
            }
            maxFreq = Math.max(maxFreq, right-left+1);
        }
        return maxFreq;
    }
}