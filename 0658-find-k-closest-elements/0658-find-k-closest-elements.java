class Solution {
    class Pair {
        int val;
        int dist;
        public Pair (int val, int dist) {
            this.val = val;
            this.dist = dist;
        }
    }
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> {
            if(a.dist == b.dist) return a.val-b.val;
            else return a.dist - b.dist;
        });
        for(int i: arr) {
            pq.offer(new Pair(i, Math.abs(x-i)));
        }
        Integer[] res = new Integer[k];
        for(int i = 0; i<k; i++){
            res[i] = pq.poll().val;
        }
        Arrays.sort(res);
        return new ArrayList<>(Arrays.asList(res));
        
    }
}