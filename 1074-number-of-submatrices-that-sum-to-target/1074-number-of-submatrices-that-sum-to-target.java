class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for(int i = 0; i<m; i++) {
            for(int j = 1; j<n; j++){
                matrix[i][j] += matrix[i][j-1];
            }
        }

        int count = 0;
        for(int c1 = 0; c1<n; c1++) {
            for(int c2 = c1; c2<n; c2++) {
                Map<Integer, Integer> map = new HashMap<>();
                map.put(0,1);
                int prefix = 0;
                for(int row = 0; row<m; row++) {
                    prefix += matrix[row][c2] - (c1>0? matrix[row][c1-1] : 0);
                    count += map.getOrDefault(prefix-target,0);
                    map.put(prefix, map.getOrDefault(prefix, 0)+1);
                }
            }
        }
        return count;
    }
}