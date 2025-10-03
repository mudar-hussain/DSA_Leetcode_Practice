class Solution {
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null || heightMap.length == 0 || heightMap[0].length == 0) return 0;

        int m = heightMap.length, n = heightMap[0].length;
        boolean[][] visited = new boolean[m][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 0; i < m; i++) {
            pq.offer(new int[]{heightMap[i][0], i, 0});
            visited[i][0] = true;
            if (n - 1 != 0) {
                pq.offer(new int[]{heightMap[i][n - 1], i, n - 1});
                visited[i][n - 1] = true;
            }
        }

        for (int j = 0; j < n; j++) {
            if (!visited[0][j]) {
                pq.offer(new int[]{heightMap[0][j], 0, j});
                visited[0][j] = true;
            }
            if (!visited[m - 1][j]) {
                pq.offer(new int[]{heightMap[m - 1][j], m - 1, j});
                visited[m - 1][j] = true;
            }
        }

        int ans = 0;
        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int h = cur[0], x = cur[1], y = cur[2];

            for (int[] d : dirs) {
                int nx = x + d[0], ny = y + d[1];
                if (nx >= 0 && nx < m && ny >= 0 && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    int nh = heightMap[nx][ny];
                    if (h > nh) ans += (h - nh);
                    pq.offer(new int[]{Math.max(h, nh), nx, ny});
                }
            }
        }

        return ans;
    }
}
 
