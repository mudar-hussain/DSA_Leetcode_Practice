class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum3(int k, int n) {
        res = new ArrayList<>();
        dfs(k, n, new ArrayList<>(), 1, 0);
        return res;
    }
    private void dfs(int k, int n, List<Integer> curr, int idx, int sum) {
        if(curr.size()==k && sum == n) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx>9 || sum>n) return;
        dfs(k, n, curr, idx+1, sum);
        curr.add(idx);
        dfs(k, n, curr, idx+1, sum + idx);
        curr.remove(curr.size()-1);
    }
}