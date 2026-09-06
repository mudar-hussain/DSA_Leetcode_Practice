class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(nums, res, 0);
        return res;
    }
    private void backtrack(int[] nums, List<List<Integer>> res, int index) {
        if(index == nums.length) {
            res.add(Arrays.stream(nums).boxed().toList());
            return;
        }
        for(int i = index; i<nums.length; i++) {
            swap(nums, i,index);
            backtrack(nums, res, index+1);
            swap(nums, i, index);
        }
    }
    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp; 
    }
}