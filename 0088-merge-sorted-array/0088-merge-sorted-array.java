class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0) {
            while(--n>=0) {
                nums1[n] = nums2[n];
            }
            
            return;
        }
        if(n==0) return;
        int l = m-1;
        int r = n-1;
        int idx = m+n-1;
        while(idx>=0 && r>=0 && l>=0) {
            if(nums1[l]>=nums2[r]){
                nums1[idx] = nums1[l];
                l--;
            } else {
                nums1[idx] = nums2[r];
                r--;
            }
            idx--;
        }
        if(idx>=0 && l<=0 && r>=0) {
            while(r>=0) {
                nums1[idx] = nums2[r];
                r--;
                idx--;
            }
            
        } else if (idx>=0 && l>=0 && r<=0) {
            while(l>=0) {
                nums1[idx] = nums1[l];
                l--;
                idx--;
            }
        }

    }
}