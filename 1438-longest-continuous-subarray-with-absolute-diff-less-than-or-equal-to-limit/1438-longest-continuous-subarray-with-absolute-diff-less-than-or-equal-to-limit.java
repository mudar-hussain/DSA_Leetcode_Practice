class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int res = 0;
        int left = 0;
        Deque<Integer> minDeque = new ArrayDeque<>();
        Deque<Integer> maxDeque = new ArrayDeque<>();
        for(int right = 0; right<nums.length; right++) {
            while(!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[right]) {
                minDeque.pollLast();
            }
            while(!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[right]) {
                maxDeque.pollLast();
            }
            minDeque.offerLast(right);
            maxDeque.offerLast(right);
            while(nums[maxDeque.peekFirst()]-nums[minDeque.peekFirst()] > limit) {
                if(maxDeque.peekFirst() == left) maxDeque.pollFirst();
                if(minDeque.peekFirst() == left) minDeque.pollFirst();
                left++;
            }
            res = Math.max(res, right-left+1);
        }
        return res;
    }
}