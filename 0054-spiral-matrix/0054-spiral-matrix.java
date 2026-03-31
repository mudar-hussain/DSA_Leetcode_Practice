class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int top = 0, bottom = m-1, left = 0, right = n-1;
        List<Integer> ans = new ArrayList<>();
        while(top<=bottom && left<=right){
            //left->right
            for(int i = left; i<=right; i++){
                ans.add(matrix[top][i]);
            }
            top++;

            //top->bottom
            for(int i = top; i<=bottom; i++){
                ans.add(matrix[i][right]);
            }
            right--;

            if(top<=bottom){
                //right->left
                for(int i = right; i>=left; i--){
                    ans.add(matrix[bottom][i]);
                }
                bottom--;
            }

            if(left<=right){
                //bottom->top
                for(int i = bottom; i>=top; i--){
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }
}