class Solution {

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int i = nums.length-1;
        int j = i;
        while(i>=0) {
            j = i;
            int smallest = -1;
            while(j>=0 && nums[i]-nums[j]<=k) {
                smallest = j;
                j--;
            }
            i = smallest-1;
            res++;
        }
        return res;
        
    }
}