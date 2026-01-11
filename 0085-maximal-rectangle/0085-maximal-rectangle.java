class Solution {
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] heights = new int[n];
        int maxArea = 0;
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                if(matrix[i][j] == '1') heights[j]+=1;
                else heights[j] = 0;
            }
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }
        return maxArea;
    }
    
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int ans = 0;
        int[] lr = new int[n];
        int[] rl = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i<n; i++){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) {
                lr[i] = -1;
            }else {
                lr[i] = st.peek();
            }
            st.push(i);
        }
        st.clear();
        for(int i = n-1; i>=0; i--){
            while(!st.isEmpty() && heights[st.peek()]>=heights[i]){
                st.pop();
            }
            if(st.isEmpty()) {
                rl[i] = n;
            }else {
                rl[i] = st.peek();
            }
            st.push(i);
        }
        for(int i = 0; i<n; i++){
            int width = rl[i] - lr[i] - 1;
            ans = Math.max(ans, Math.abs(heights[i]*width));
        }
        return ans;
    }
}