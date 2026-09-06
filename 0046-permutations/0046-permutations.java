class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, new ArrayList<>(), used, res);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> list, boolean[] used, List<List<Integer>> res) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(used[i] == true) continue;
            used[i] = true;
            list.add(nums[i]);
            backtrack(nums, list, used, res);
            used[i] = false;
            list.remove(list.size()-1);
        }
    }
}