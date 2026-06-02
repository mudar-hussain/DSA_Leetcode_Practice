class Solution {
    private boolean isValidOperations(int[] nums, int penalty, int maxOps) {
        int count = 0;
        for(int n: nums) {
            count += (n-1)/penalty;
            if(count>maxOps) return false;
        }
        return true;
    }
    public int minimumSize(int[] nums, int maxOperations) {
        int low = 1, high = Arrays.stream(nums).max().getAsInt();
        while(low<high) {
            int mid = low + (high-low)/2;
            if(isValidOperations(nums, mid, maxOperations)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return high;
    }
}