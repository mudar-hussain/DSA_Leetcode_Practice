class Solution {
    public void setZeroes(int[][] matrix) {
        Set<Integer> si = new HashSet<>();
        Set<Integer> sj = new HashSet<>();
        for(int i = 0; i<matrix.length; i++) {
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j]==0){
                    si.add(i);
                    sj.add(j);
                }
            }
        }
        si.forEach(i -> {
            for(int j = 0; j<matrix[i].length; j++){
                matrix[i][j] = 0;
            }
        });
        sj.forEach(j -> {
            for(int i = 0; i<matrix.length; i++){
                matrix[i][j] = 0;
            }
        });
        
        
    }
}