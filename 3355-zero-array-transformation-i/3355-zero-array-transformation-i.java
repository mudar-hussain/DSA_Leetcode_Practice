class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n];
        for(int[] query: queries) {
            diff[query[0]]--;
            if(query[1]+1<n) diff[query[1]+1]++;
        }
        for(int i = 0; i<n; i++){
            if(i>0)diff[i] += diff[i-1];
            if(nums[i]+diff[i]>0) return false;
        }
        return true;
    }
}