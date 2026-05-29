class Solution {
    public class Pair {
        long time;
        int room;
        public Pair(long time, int room) {
            this.time = time;
            this.room = room;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        int[] freq = new int[n];
        PriorityQueue<Pair> free = new PriorityQueue<>(
            (a,b) -> Integer.compare(a.room,b.room)
        );
        PriorityQueue<Pair> occupied = new PriorityQueue<>(
            (a,b) -> a.time==b.time ? Integer.compare(a.room,b.room) : Long.compare(a.time,b.time)
        );
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        for (int i = 0; i < n; i++) {
            free.add(new Pair(0L, i));
        }
        for(int i = 0; i<meetings.length; i++) {
            long start = 1L * meetings[i][0];
            long end = 1L * meetings[i][1];
            while(!occupied.isEmpty() && occupied.peek().time <= start) {
                free.add(occupied.poll());
            }
            Pair temp;
            if(!free.isEmpty()) {
                temp = free.poll();
                temp.time = end;
            } else {
                temp = occupied.poll();
                temp.time += end - start;
            }
            freq[temp.room]++;
            occupied.add(temp);
        }
        int mostMeet = -1;
        int result = -1;
        for(int i = 0; i<freq.length; i++) {
            if(mostMeet<freq[i]){
                mostMeet = freq[i];
                result = i;
            }
        }
        return result;
    }
}