class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int left = 0, right = 0, score = 0, currScore = 0;
        Set<Integer> set = new HashSet<>();
        while(right<n) {
            while(set.contains(nums[right])) {
                currScore -= nums[left];
                set.remove(nums[left++]);
            }
            set.add(nums[right]);
            currScore += nums[right];
            score = Math.max(score, currScore);
            right++;
        }
        return score;
    }
}