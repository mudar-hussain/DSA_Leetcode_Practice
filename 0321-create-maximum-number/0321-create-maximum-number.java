class Solution {
    private int[] maxSeq(int[] nums, int k) {
        int[] res = new int[k];
        int drop = nums.length - k;
        Deque<Integer> deq = new ArrayDeque<>();
        for(int num: nums) {
            while(drop>0 && !deq.isEmpty() && deq.peekLast() < num) {
                deq.pollLast();
                drop--;
            }
            deq.addLast(num);
        }
        int i = 0;
        for(int num: deq) {
            if(i==k) break;
            res[i++] = num;
        }
        return res;
    }

    private boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while(i<nums1.length && j<nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j==nums2.length || (i<nums1.length && nums1[i]>nums2[j]);
    }

    private int[] merge(int[] nums1, int[] nums2) {
        int i = 0, j = 0, r = 0;
        int[] res = new int[nums1.length+nums2.length];
        while(i<nums1.length || j<nums2.length) {
            res[r++] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
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