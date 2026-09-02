class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        long maxSum = 0;
        long currSum = 0;
        Set<Integer> set = new HashSet<>();
        int left = 0, right = 0;
        while(right<n) {
            while(set.contains(nums[right])) {
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            set.add(nums[right]);
            currSum += nums[right];
            if(right-left+1 == k) {
                maxSum = Math.max(maxSum, currSum);
                set.remove(nums[left]);
                currSum -= nums[left];
                left++;
            }
            right++;
        }
        return maxSum;
    }
}