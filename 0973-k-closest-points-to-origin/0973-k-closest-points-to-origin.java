class Solution {
    class Pair {
        int[] point;
        double dist;
        public Pair(int[] point, double dist) {
            this.point = point;
            this.dist = dist;
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(a.dist, b.dist));
        for(int[] point: points) {
            int x = point[0];
            int y = point[1];
            double dist = Math.sqrt(x*x + y*y);
            pq.offer(new Pair(point, dist));
        }
        int[][] res = new int[k][2];
        for(int i = 0; i<k; i++) {
            res[i] = pq.poll().point;
        }
        return res;
    }
}