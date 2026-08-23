class Solution {
    class Pair {
        int[] point;
        long dist;
        public Pair(int[] point, long dist) {
            this.point = point;
            this.dist = dist;
        }
    }
    public int[] resultsArray(int[][] queries, int k) {
        Queue<Long> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[queries.length];
        for(int i = 0; i<queries.length; i++) {
            long dist = Math.abs(queries[i][0])+Math.abs(queries[i][1]);
            pq.offer(dist);
            while(pq.size()>k) pq.poll();
            res[i] = pq.size() == k ? pq.peek().intValue() : -1;
        }
        return res;
    }
}