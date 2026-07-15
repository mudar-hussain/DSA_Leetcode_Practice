class Solution {
    public long numberOfSubarrays(int[] nums) {
        int n = nums.length;
        Stack<int[]> st = new Stack<>();
        long ans = 0;
        for(int i: nums) {
            while(!st.isEmpty() && st.peek()[0]<i) {
                st.pop();
            }
            if(!st.isEmpty() && st.peek()[0]==i) {
                st.peek()[1]++;
                ans += st.peek()[1];
            } else {
                ans++;
                st.push(new int[]{i, 1});
            }
        }
        return ans;
        
    }
}