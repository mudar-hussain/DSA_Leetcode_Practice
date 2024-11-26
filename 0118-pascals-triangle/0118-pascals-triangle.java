class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i = 0; i<numRows; i++) {
            List<Integer> li = new ArrayList<>();
            for (int j = 0; j<=i; j++) {
                if(j == 0 || j == i) {
                    li.add(1);
                    continue;
                }
                li.add(ans.get(i-1).get(j-1) + ans.get(i-1).get(j));
            }
            ans.add(li);
        }
        return ans;
    }
}