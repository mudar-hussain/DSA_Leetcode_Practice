class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0, right = n-1;
        for(int i = 0, j=n-1; i<n; i++, j--) {
            if(nums[i]<pivot) {
                res[left++] = nums[i];
            }
            if(nums[j]>pivot) {
                res[right--] = nums[j];
            }
        }
        while(left<=right) {
            res[left++] = pivot;
        }
        return res;
        
    }
}