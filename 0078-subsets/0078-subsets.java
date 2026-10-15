class Solution {
    List<List<Integer>> res = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> curr = new ArrayList<>();
        this.subsets(nums, 0, new ArrayList<>());
        return res;
    }

    private void subsets(int[] nums, int idx, List<Integer> curr) {
        if(idx>=nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        this.subsets(nums, idx+1, curr);
        curr.add(nums[idx]);
        this.subsets(nums, idx+1, curr);
        // Backtrack
        curr.remove(curr.size() - 1);
    }
}