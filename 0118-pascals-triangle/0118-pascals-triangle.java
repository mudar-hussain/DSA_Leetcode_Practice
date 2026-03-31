class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> pascal = new ArrayList<>();
        for (int i = 0; i<numRows; i++) {
            List<Integer> inPascal = new ArrayList<>();
            List<Integer> temp = new ArrayList<>();
            if(i>0) temp = pascal.get(i-1);
            for (int j = 0; j<=i; j++) {
                if(j == 0 || j == i) {
                    inPascal.add(1);
                } else {
                    inPascal.add(temp.get(j-1)+temp.get(j));
                }
            }
            pascal.add(inPascal);
        }
        return pascal;
    }
}