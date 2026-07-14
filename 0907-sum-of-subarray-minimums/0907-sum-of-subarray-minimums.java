class Solution {
    public int sumSubarrayMins(int[] nums) {
        int n = nums.length;
        int MOD = (int)1e9+7;
        long ans = 0;
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<=n; i++) {
            while(!st.isEmpty() && (i==n || nums[st.peek()] >= nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                long contribution = (long)nums[mid] * (mid-left) * (i-mid);
                ans = (ans + contribution) % MOD;
            }
            st.push(i);
        }
        return (int) ans;
        
    }
}