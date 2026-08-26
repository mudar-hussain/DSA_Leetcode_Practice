class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        if(k == 1) return matrix[0][0];
        int n = matrix.length;
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<n; i++) {
            for(int j = 0; j<n; j++) {
                if(pq.size()==k && pq.peek()>matrix[i][j]) {
                    pq.poll();
                }
                if(pq.size()<k) {
                    pq.add(matrix[i][j]);
                }
            }
        }
        return pq.peek();
        
    }
}