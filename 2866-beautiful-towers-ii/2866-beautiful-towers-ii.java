class Solution {
    public long maximumSumOfHeights(List<Integer> nums) {
        int n = nums.size();
        long[] left = new long[n];
        long[] right = new long[n];
        Stack<Integer> st = new Stack<>();
        long maxHeight = 0L;
        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && nums.get(st.peek()) > nums.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                left[i] = (long) nums.get(i) * (i+1);
            } else {
                int j = st.peek();
                left[i] = left[j] + (long) nums.get(i) * (i-j);
            }
            st.push(i);
        }
        st.clear();
        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && nums.get(st.peek()) > nums.get(i)) {
                st.pop();
            }
            if(st.isEmpty()) {
                right[i] = (long) nums.get(i) * (n-i);
            } else {
                int j = st.peek();
                right[i] = right[j] + (long) nums.get(i) * (j-i);
            }
            st.push(i);
        }
        for(int i = 0; i<n; i++) {
            maxHeight = Math.max(maxHeight, left[i]+right[i]-nums.get(i));
        }
        return maxHeight;
    }
}