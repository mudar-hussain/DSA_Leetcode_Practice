class Solution {
    public boolean partitionArray(int[] nums, int k) {
        int n = nums.length;
        if(n%k != 0) return false;
        int[] freq = new int[1000001];
        for(int i = 0; i<n; i++){
            freq[nums[i]]++;
            if(freq[nums[i]] > n/k) return false;
        }


        return true;
        
    }
}