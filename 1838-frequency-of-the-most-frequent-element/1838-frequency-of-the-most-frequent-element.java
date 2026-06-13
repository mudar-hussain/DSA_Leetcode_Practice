class Solution {
    private boolean isPossible(int[] nums, int k, int low, int high) {
        long currOps = 0;
        for(int i = low; i<=high; i++) {
            currOps += (long)nums[high]-nums[i];
            if(currOps > (long)k) return false;
        }
        return true;
    }
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int maxFreq = 1;
        for(int j = nums.length-1; j>=maxFreq; j--) {
            int i = j-1;
            int currOps = 0;
            while(i>=0) {
                currOps += (nums[j]-nums[i]);
                if(currOps>k) {
                    i++;
                    break;
                }else {
                    i--;
                }
            }
            i = Math.max(i, 0);
            maxFreq = Math.max(maxFreq, j-i+1);
        }
        return maxFreq;
    }
}