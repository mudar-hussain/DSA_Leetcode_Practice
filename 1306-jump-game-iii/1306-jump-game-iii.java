class Solution {
    public boolean canReach(int[] arr, int start) {
        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        q.offer(start);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int idx = q.poll();
                visited[idx] = true;
                int[] next = {idx+arr[idx], idx-arr[idx]};
                for(int n: next) {
                    if(n>=0 && n<arr.length) {
                        if(arr[n]==0) return true;
                        if(!visited[n]) q.offer(n);
                    }
                }
            }
        }
        return false;
        
    }
}