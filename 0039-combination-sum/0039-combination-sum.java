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
        curr.add(candidates[idx]);
        sum += candidates[idx];
        dfs(candidates, target, sum, curr, idx);
        // dfs(candidates, target, sum, curr, idx+1);
        curr.remove(curr.size()-1);
        sum -= candidates[idx];
        int next = idx+1;
        // while(next<candidates.length && candidates[next]==candidates[idx]) next++;
        dfs(candidates, target, sum, curr, next);
    }
}