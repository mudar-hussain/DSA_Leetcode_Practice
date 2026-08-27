class Solution {
    public int maxEvents(int[][] events) {
        int n = events.length;
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        Queue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        int countEvents = 0;
        int totalDays = 0;
        for(int[] e: events) {
            totalDays= Math.max(totalDays, e[1]);
        }
        for(int days = 1; days<=totalDays; days++) {
            while(idx<n && events[idx][0] == days) {
                pq.offer(events[idx][1]);
                idx++;
            }
            while(!pq.isEmpty() && pq.peek()<days) {
                pq.poll();
            }
            if(!pq.isEmpty()){
                pq.poll();
                countEvents++;
            }
            if(idx>=n && pq.isEmpty()) break;
        }
        return countEvents;
        
    }
}