class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> subsets(int[] nums) {
        res = new ArrayList<>();
        subsets(nums, new ArrayList<>(), 0);
        return res;
    }
    private void subsets(int[] nums, List<Integer> curr, int idx){
        if(idx>=nums.length) {
            res.add(new ArrayList<>(curr));
            return;
        }
        subsets(nums, curr, idx+1);
        // for(int i = idx; i<nums.length; i++) {
            curr.add(nums[idx]);
            // int currSize= curr.size();
            subsets(nums, curr, idx+1);
            curr.remove(curr.size()-1);
        // }
    }
}