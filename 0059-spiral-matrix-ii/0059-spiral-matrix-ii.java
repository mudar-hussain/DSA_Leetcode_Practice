class Solution {
    public int[][] generateMatrix(int n) {
        int[][] ans = new int[n][n];
        int k = 1;
        int top = 0, bottom = n-1, left = 0, right = n-1;
        while(top<=bottom && left<=right){
            //left->right
            for(int i = left; i<=right; i++){
                ans[top][i] = k++;
            }
            top++;

            //top->bottom
            for(int i = top; i<=bottom; i++){
                ans[i][right] = k++;
            }
            right--;

            if(top<=bottom){
                //right->left
                for(int i = right; i>=left; i--){
                    ans[bottom][i] = k++;
                }
                bottom--;
            }

            if(left<=right){
                //bottom->top
                for(int i = bottom; i>=top; i--){
                    ans[i][left] = k++;
                }
                left++;
            }
        }
        return ans;
    }
}