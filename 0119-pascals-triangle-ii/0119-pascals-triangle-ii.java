class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        long k =1;
        row.add((int)k);
        for(int i = 1; i<=rowIndex; i++){
            k  = k * (rowIndex-i+1) / (i);
            row.add((int)k);
        }
        return row;

    }
}