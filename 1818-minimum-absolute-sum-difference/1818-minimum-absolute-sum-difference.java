class Solution {
    private int lowerBound(int[] nums, int k) {
        int low = 0, high = nums.length-1;
        while(low<high) {
            int mid = low + (high-low)/2;
            // if(nums[mid]==k) return mid;
            // else 
            if(nums[mid]>=k){
                high = mid;
            } else low = mid + 1;
        }
        return high;
    }
    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int MOD = (int)1e9+7;
        int[] snums1 = nums1.clone();
        Arrays.sort(snums1);
        long absDiff = 0;
        for(int i = 0; i<nums1.length; i++) {
            absDiff += Math.abs(nums1[i]-nums2[i]);
        }
        long res = absDiff;
        for(int i = 0; i<nums2.length; i++) {
            if(nums1[i] == nums2[i]) continue;
            int idx = lowerBound(snums1, nums2[i]);
            int left = idx==0 ? idx:idx-1;
            int right = idx==nums2.length?idx-1:idx;
            int diff = Math.min(Math.abs(nums2[i] - snums1[left]),Math.abs(nums2[i] - snums1[right]));
            res = Math.min(res, absDiff - Math.abs(nums1[i]-nums2[i]) + diff);
        }
        return (int)(res % MOD);
    }
}