class Solution {
    public int minOperations(int[] nums) {
        int res = 0;
        Stack<Integer> st = new Stack<>();
        for(int n: nums) {
            while(!st.isEmpty() && st.peek() > n) {
                st.pop();
            }
            if(n==0) continue;
            if(st.isEmpty() || st.peek() < n) {
                res++;
                st.push(n);
            }
        }
        return res;
        
    }
}