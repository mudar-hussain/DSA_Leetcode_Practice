class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1, j = n-1;
        int idx = m+n-1;
        while(idx>=0 && i>=0 && j>=0) {
            if (nums2[j] > nums1[i]) {
                nums1[idx] = nums2[j];
                j--;
            } else {
                nums1[idx] = nums1[i];
                i--;
            }
            idx--;
        }
        while(idx>=0 && i>=0) {
            nums1[idx] = nums1[i];
            i--;
            idx--;
        }
        while(idx>=0 && j>=0) {
            nums1[idx] = nums2[j];
            j--;
            idx--;
        }

    }
}