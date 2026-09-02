class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        int left = 0, right = 0;
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> b[1]-a[1]);
        while(right<n && right-left+1<k) {
            pq.offer(new int[]{right, nums[right++]});
        }
        while(right<n) {
            pq.offer(new int[]{right, nums[right++]});
            while(!pq.isEmpty() && pq.peek()[0]<left) {
                pq.poll();
            }
            res[left++] = pq.peek()[1];
        }
        return res;

    }
}