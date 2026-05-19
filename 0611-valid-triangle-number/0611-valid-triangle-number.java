class Solution {
    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        int count = 0;
        for(int i = nums.length-1; i>=2; i--){
            int low = 0, high = i-1;
            while(low<high){
                if(nums[low]+nums[high] > nums[i]) {
                    count += high-low;
                    high--;
                } else low++;
            }
        }
        return count;
        
    }
}