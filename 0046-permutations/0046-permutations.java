class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, new ArrayList<>(), new HashSet<>(), res);
        return res;
    }
    private void backtrack(int[] nums, List<Integer> list, Set<Integer> set, List<List<Integer>> res) {
        if(list.size() == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i<nums.length; i++) {
            if(set.contains(nums[i])) continue;
            set.add(nums[i]);
            list.add(nums[i]);
            backtrack(nums, list, set, res);
            set.remove(list.get(list.size()-1));
            list.remove(list.size()-1);
        }
    }
}