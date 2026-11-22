class Solution {
    //fromDir = 1->top, 2->right, 3-> bottom, 4->left
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board[0].length; j++) {
                if(dfs(board, word, i, j, 0)) {
                    return true; 
                }
            }
        }
        return false;
    }
    private boolean dfs(char[][] board, String word, int i, int j, int idx){
        if(idx==word.length()){
            return true;
        }
        if(i<0 || j<0 || i>=board.length || j>=board[0].length || board[i][j] != word.charAt(idx)) return false;
        char temp = board[i][j];
        board[i][j] = '#';
        for(int k = 0; k<4; k++) {
            if(dfs(board, word, i+dx[k], j+dy[k], idx+1)) {
                board[i][j] = temp;
                return true;
            }
        }
        board[i][j] = temp;
        return false;
    }

}