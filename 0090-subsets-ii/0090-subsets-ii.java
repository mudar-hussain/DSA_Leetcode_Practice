class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        res = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, new ArrayList<>(), 0);
        return res;
    }

    private void dfs(int[] nums, List<Integer> curr, int idx) {
        if(idx >= nums.length){
            res.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        dfs(nums, curr, idx+1);
        curr.remove(curr.size()-1);
        int next = idx+1;
        while(next<nums.length && nums[next] == nums[idx]) next++;
        dfs(nums, curr, next);
    }
}