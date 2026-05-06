class Solution {
    private int[] maxSeq(int[] nums, int k) {
        int drop = nums.length - k;
        Deque<Integer> st = new ArrayDeque<>();

        for(int num : nums){
            while(drop > 0 && !st.isEmpty() && st.peekLast() < num){
                st.pollLast();
                drop--;
            }
            st.addLast(num);
        }

        int[] res = new int[k];
        int i = 0;
        for(int num : st){
            if(i == k) break;
            res[i++] = num;
        }

        return res;
    }

    private boolean greater(int[] a, int i, int[] b, int j) {
        while(i<a.length && j<b.length && a[i]==b[j]){
            i++;
            j++;
        }
        return j==b.length || (i<a.length && a[i]>b[j]);
    }
    private int[] merge(int[] a, int[] b) {
        int n = a.length+b.length;
        int[] res = new int[n];
        int i = 0, j = 0, r = 0;
        while(i<a.length || j<b.length) {
            res[r++] = greater(a, i, b, j) ? a[i++] : b[j++];
        }
        return res;
    }
    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int[] best = new int[k];
        for(int i = Math.max(0, k-nums2.length); i<=Math.min(k, nums1.length); i++) {
            int[] a = maxSeq(nums1, i);
            int[] b = maxSeq(nums2, k-i);

            int[] candidate = merge(a, b);
            best = greater(candidate, 0, best, 0) ? candidate : best;
        }
        return best;
    }
}