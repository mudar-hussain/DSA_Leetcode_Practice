class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int res = 0;
        int[] nums = new int[n];
        for(int i = 0; i<m; i++) {
            for(int j = 0; j<n; j++) {
                if(matrix[i][j] == '1') {
                    nums[j]++;
                } else {
                    nums[j] = 0;
                }
            }
            res = Math.max(res, largestRectangleArea(nums));
        }
        return res;
        
    }
    public int largestRectangleArea(int[] nums) {
        int n = nums.length;
        long res = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] >= nums[i]) {
                st.pop();
            }
            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        for(int i = 0; i<n; i++) {
            res = Math.max(res, (right[i]-left[i]-1)*(long)nums[i]);
        }
        return (int)res;
    }
}