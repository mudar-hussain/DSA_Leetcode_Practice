class Solution {
    public long subArrayRanges(int[] nums) {
        // return sumMax(nums) - sumMin(nums);
        return sum(nums, true) - sum(nums, false);
    }

    private long sum(int[] nums, boolean isMax) {
        int n = nums.length;
        long ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<=n; i++) {
            while(!st.isEmpty() && (i==n || (isMax ? nums[st.peek()] <= nums[i] : nums[st.peek()] >= nums[i]))) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                ans += (long) nums[mid] * (mid-left) * (i-mid);
            }
            st.push(i);
        }
        return ans;

    }
    private long sumMax(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<=n; i++) {
            while(!st.isEmpty() && (i==n || nums[st.peek()] <= nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                ans += (long) nums[mid] * (mid-left) * (i-mid);
            }
            st.push(i);
        }
        return ans;
    }
    private long sumMin(int[] nums) {
        int n = nums.length;
        long ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<=n; i++) {
            while(!st.isEmpty() && 
                    (i==n || nums[st.peek()] >= nums[i])) {
                int mid = st.pop();
                int right = st.isEmpty() ? -1 : st.peek();
                ans += (long) nums[mid] * (mid - right) * (i - mid);
            }
            st.push(i);
        }
        return ans;
    }
}