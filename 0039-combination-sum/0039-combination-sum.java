class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        res = new ArrayList<>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] candidates, int target, int sum, List<Integer> curr, int idx) {
        if(sum == target) {
            res.add(new ArrayList<>(curr));
            return;
        }
        if(idx>=candidates.length || sum>target || candidates[idx] > target) {
            return;
        }
        dfs(candidates, target, sum, curr, idx+1);
        
        curr.add(candidates[idx]);
        dfs(candidates, target, sum + candidates[idx], curr, idx);
        curr.remove(curr.size()-1);
    }
}