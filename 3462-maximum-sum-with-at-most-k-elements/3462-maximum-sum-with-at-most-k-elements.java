class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        Queue<Integer>[] pq = new Queue[grid.length];
        for(int i = 0; i<grid.length; i++) {
            pq[i] = new PriorityQueue<>(Collections.reverseOrder());
            for(int j = 0; j<grid[i].length; j++) {
                pq[i].offer(grid[i][j]);
            }
        }
        Queue<Integer> max = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<grid.length; i++) {
            for(int j = 0; j<limits[i]; j++) {
                max.offer(pq[i].poll());
            }
        }
        long res = 0;
        while(k-->0) {
            res += max.poll();
        }
        return res;
    }
}