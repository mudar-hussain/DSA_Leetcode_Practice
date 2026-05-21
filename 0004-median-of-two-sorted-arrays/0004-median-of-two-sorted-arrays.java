class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length>nums2.length) return findMedianSortedArrays(nums2, nums1);
        int n = nums1.length, m = nums2.length;
        int low = 0, high = n;
        while(low<=high) {
            int partNums1 = low + (high-low)/2;
            int partNums2 = (n+m+1)/2 - partNums1;

            int x = partNums1 == 0 ? Integer.MIN_VALUE : nums1[partNums1-1];
            int y = partNums1 == n ? Integer.MAX_VALUE : nums1[partNums1];

            int p = partNums2 == 0 ? Integer.MIN_VALUE : nums2[partNums2-1];
            int q = partNums2 == m ? Integer.MAX_VALUE : nums2[partNums2];

            if(x<=q && p<=y) {
                if((m+n)%2 == 0) {
                    return ((double)Math.max(x, p) + (double)Math.min(y, q))/2.0;
                } else {
                    return (double)Math.max(x, p);
                }
            } else if(x > q) {
                high = partNums1 - 1;
            } else {
                low = partNums1 + 1;
            }
        }
        return 0.0;
        
    }
}