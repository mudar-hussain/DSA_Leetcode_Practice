class Solution {
    private boolean isPossible(int[] nums, int[] changeIndices, int time) {
        int[] last = new int[nums.length];
        Arrays.fill(last, -1);
        for(int i = 0; i<time; i++) {
            last[changeIndices[i]-1] = i;
        }
        for(int i: last) if(i==-1) return false;
        int dec = 0;
        int marked = 0;
        for(int i = 0; i<time; i++) {
            int idx = changeIndices[i]-1;
            if(last[idx] == i) {
                if(dec < nums[idx]) return false;
                dec -= nums[idx];
                marked++;
            } else {
                dec++;
            }
        }
        return marked==nums.length;

    }
    public int earliestSecondToMarkIndices(int[] nums, int[] changeIndices) {
        int low = 1, high = changeIndices.length;
        int ans = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(isPossible(nums, changeIndices, mid)){
                ans = mid;
                high = mid -1;
            } else low = mid + 1;
        }
        return ans;        
    }
}