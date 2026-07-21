class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(start);
        boolean[] visited = new boolean[1001];
        if(start>=0 && start<=1000) visited[start] = true;
        int steps = 0;
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int x = q.poll();
                for(int n: nums) {
                    int[] next = {x+n, x-n, x^n};
                    for(int y: next) {
                        if(y==goal) return steps+1;
                        if(y>=0 && y<=1000 && !visited[y]) {
                            q.offer(y);
                            visited[y] = true;
                        }
                    }
                }
            }
            steps++;
        }
        return -1;
        
    }
}