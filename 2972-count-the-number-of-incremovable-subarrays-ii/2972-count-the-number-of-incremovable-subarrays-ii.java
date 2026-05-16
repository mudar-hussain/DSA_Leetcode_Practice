class Solution {
    public long incremovableSubarrayCount(int[] nums) {
        long ans = 1;
        int r = 1;
        int n = nums.length;

        while (r < n && nums[r] > nums[r - 1]) {
            r++;
        }

        if (r == n) {
            return (long) n * (n + 1) / 2;
        }

        int lst = Integer.MAX_VALUE;
        ans += r;

        for (int i = n - 1; i >= 0; i--) {
            if (nums[i] >= lst) {
                break;
            }
            int low = 0, high = r - 1;
            int left = -1;

            while (low <= high) {
                int mid = (low + high) >> 1;
                if (nums[mid] < nums[i]) {
                    left = mid;
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }

            ans += (left + 2);
            lst = nums[i];
        }

        return ans;
    }
}

