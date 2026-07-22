class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int n = s.length();
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int farthest = 1;
        while (!q.isEmpty()) {

            int curr = q.poll();

            int start = Math.max(curr + minJump, farthest);
            int end = Math.min(curr + maxJump, n - 1);

            for (int i = start; i <= end; i++) {

                if (s.charAt(i) == '0' && !visited[i]) {

                    if (i == n - 1)
                        return true;

                    visited[i] = true;
                    q.offer(i);
                }
            }

            farthest = Math.max(farthest, end + 1);
        }

        return n == 1;
    }
}