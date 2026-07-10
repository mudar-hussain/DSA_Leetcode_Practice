class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        for(int i = 0; i<2*n; i++) {
            while(!st.isEmpty() && nums[st.peek()]<nums[i%n]) {
                ans[st.pop()] = nums[i%n];
            }
            if(i<n) st.push(i);
        }

        return ans;
    }
}