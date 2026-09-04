class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n = nums.length;
        int left = 0, right = 0;
        int count = 0, odd = 0, prefixEven = 0;
        while(right<n) {
            if(nums[right]%2==1) {
                odd++;
                prefixEven = 0;
            }
            while(odd == k) {
                prefixEven++;
                if(nums[left++]%2 == 1) odd--;
            }
            count += prefixEven;
            right++;
        }
        return count;
    }
}