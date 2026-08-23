class Solution {
    public int[] resultsArray(int[][] queries, int k) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int[] res = new int[queries.length];
        for(int i = 0; i<queries.length; i++) {
            pq.offer(Math.abs(queries[i][0])+Math.abs(queries[i][1]));
            while(pq.size()>k) pq.poll();
            res[i] = pq.size() == k ? pq.peek() : -1;
        }
        return res;
    }
}