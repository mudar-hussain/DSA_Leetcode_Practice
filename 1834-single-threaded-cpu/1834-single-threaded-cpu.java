class Solution {
    class Task {
        int idx;
        int enqueueTime;
        int processingTime;
        public Task(int idx, int enqueueTime , int processingTime) {
            this.idx = idx;
            this.enqueueTime  = enqueueTime ;
            this.processingTime = processingTime;
        }
    }
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;
        Task[] arr = new Task[n];
        for(int i = 0; i<n; i++) {
            arr[i] = new Task(i, tasks[i][0], tasks[i][1]);
        }
        Arrays.sort(arr, (a,b) -> Integer.compare(a.enqueueTime, b.enqueueTime));
        Queue<Task> pq = new PriorityQueue<>((a,b) -> {
            if(a.processingTime == b.processingTime) return Integer.compare(a.idx, b.idx);
            return Integer.compare(a.processingTime, b.processingTime);
        });
        int[] res = new int[n];
        int resIdx = 0;
        int taskIdx = 0;
        int currTime = 0;
        while(resIdx < n) {
            while(taskIdx < n && arr[taskIdx].enqueueTime<=currTime) {
                pq.offer(arr[taskIdx++]);
            }
            if(pq.isEmpty()) {
                currTime = Math.max(currTime, arr[taskIdx].enqueueTime);
            } else {
                currTime += pq.peek().processingTime;
                res[resIdx++] = pq.poll().idx;
            }

        }
        return res;
    }
}