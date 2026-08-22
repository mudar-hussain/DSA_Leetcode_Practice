class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int st: stones) {
            pq.offer(st);
        }
        while(pq.size()>1) {
            int x = pq.poll();
            int y = pq.poll();
            if(x!=y) {
                pq.offer(x-y);
            }
        }
        return pq.size() == 1 ? pq.poll() : 0;
    }
}