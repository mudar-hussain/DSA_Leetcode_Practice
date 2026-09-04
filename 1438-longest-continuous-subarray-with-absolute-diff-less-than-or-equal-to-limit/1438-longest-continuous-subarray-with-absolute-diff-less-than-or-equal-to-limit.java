class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int n = nums.length;
        int left = 0, right = 0;
        int res = 0;
        Queue<int[]> minpq = new PriorityQueue<>((a,b) -> a[0]!=b[0] ? Integer.compare(a[0], b[0]) : Integer.compare(a[1], b[1]));
        Queue<int[]> maxpq = new PriorityQueue<>((a,b) -> a[0]!=b[0] ? Integer.compare(b[0], a[0]) : Integer.compare(a[1], b[1]));
        while(right<n) {
            while(!minpq.isEmpty() && minpq.peek()[1]<left) minpq.poll();
            while(!maxpq.isEmpty() && maxpq.peek()[1]<left) maxpq.poll();
            minpq.offer(new int[]{nums[right], right});
            maxpq.offer(new int[]{nums[right], right});
            if(Math.abs(minpq.peek()[0]-maxpq.peek()[0]) > limit) {
                left++;
            } else {
                res = Math.max(res, right-left+1);
                right++;
            }
        }
        return res;

        
    }
}