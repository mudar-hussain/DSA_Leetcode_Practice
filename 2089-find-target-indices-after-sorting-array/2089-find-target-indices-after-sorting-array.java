class Solution {
    public List<Integer> targetIndices(int[] nums, int target) {
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        int low = 0, high = nums.length-1;
        int mid = -1;
        while(low<=high) {
            mid = low + (high-low)/2;
            if(nums[mid] == target) break;
            else if(nums[mid]<target) low = mid+1;
            else high = mid - 1;
        }
        if(mid == -1) return list;
        while(mid>0 && nums[mid-1] == target) mid--;
        while(mid<nums.length && nums[mid] == target) list.add(mid++);
        return list;
    }
}