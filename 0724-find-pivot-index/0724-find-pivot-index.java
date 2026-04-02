class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int sum = 0;
        for(int i = 0; i<n; i++) {
            prefix[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for(int i = n-1; i>=0; i--) {
            suffix[i] = sum;
            sum += nums[i];
        }
        // if(n>0 && suffix[1]==0) return 0;
        // if(n>0 && prefix[n-2]==0) return n-1;
        for(int i = 0; i<n; i++) {
            if(prefix[i] == suffix[i]) return i;
        }
        return -1;
    }
}