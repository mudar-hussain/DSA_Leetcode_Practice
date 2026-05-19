class Solution {
    private int lowerBound(int[] nums, int target) {
        int low = 0, high = nums.length-1;
        int res = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(nums[mid]<=target) {
                res = mid;
                low = mid+1;
            } else high = mid-1;
        }
        return res;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] first = new int[matrix.length];
        for(int i = 0; i<matrix.length; i++){
            first[i] = matrix[i][0];
        }
        int row = lowerBound(first, target);
        if (row == -1) return false;
        int col = lowerBound(matrix[row], target);
        return col!=-1 && matrix[row][col] == target;
    }
}