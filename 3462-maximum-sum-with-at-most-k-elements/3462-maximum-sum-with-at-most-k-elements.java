class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        for(int i = 0; i<grid.length; i++) {
            Arrays.sort(grid[i]);
        }
        int n = 0;
        for(int i=0; i<limits.length; i++) n += Math.min(limits[i], grid[i].length);
        int[] arr = new int[n];
        n = 0;
        for(int i = 0; i<grid.length; i++) {
            for(int j = grid[i].length - 1; j >= grid[i].length - Math.min(limits[i], grid[i].length); j--) {
                arr[n++] = grid[i][j];
            }
        }
        Arrays.sort(arr);
        long sum = 0;
        n = arr.length-1;
        while(k-->0) {
            sum += arr[n--];
        }
        return sum;
        
    }
}