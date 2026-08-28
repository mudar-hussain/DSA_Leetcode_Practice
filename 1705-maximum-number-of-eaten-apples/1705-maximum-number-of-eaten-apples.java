class Solution {
    public int eatenApples(int[] apples, int[] days) {
        int n = apples.length;
        Queue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        int idx = 0;
        int eaten = 0;
        while(idx<n || !pq.isEmpty()) {
            if(idx<n && apples[idx]>0) {
                pq.offer(new int[]{apples[idx], idx+days[idx]});
            }
            while(!pq.isEmpty() && pq.peek()[1]<=idx){
                pq.poll();
            }
            if(!pq.isEmpty()) {
                int[] batch = pq.poll();
                batch[0]--;
                eaten++;
                if(batch[0]>0) pq.offer(batch);
            }
            idx++;
        }
        return eaten;
        
    }
}