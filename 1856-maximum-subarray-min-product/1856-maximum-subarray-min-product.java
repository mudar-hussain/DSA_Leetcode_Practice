class Solution {
    public int maxSumMinProduct(int[] nums) {
        int MOD = (int) 1e9+7;
        long ans = 0;
        int n = nums.length;
        long prefix[] = new long[n+1];
        for(int i = 0; i<n; i++) {
            prefix[i+1] = prefix[i] + nums[i];
        }
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<=n; i++) {
            while(!st.isEmpty() && (i==n || nums[st.peek()] >= nums[i])) {
                int mid = st.pop();
                int left = st.isEmpty() ? -1 : st.peek();
                long sum = prefix[i] - prefix[left+1];
                ans = Math.max(ans, (nums[mid] * sum));
            }
            st.push(i);
        }
        return (int) (ans % MOD);
    }
}