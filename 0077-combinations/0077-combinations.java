class Solution {

    List<List<Integer>> res;
    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        dfs(n, k, new ArrayList<>(), 1);
        return res;
        
    }
    private void dfs(int n, int k, List<Integer> curr, int idx) {
        if(idx>n && curr.size()==k) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx>n) return;
        dfs(n, k, curr, idx+1);
        curr.add(idx);
        dfs(n, k, curr, idx+1);
        curr.remove(curr.size()-1);

    }
}