class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;
        int[] freq = new int[k];
        freq[0] = 1;
        for(int num: nums) {
            sum += num;
            int mod = sum % k;
            if(mod<0) mod += k;
            count += freq[mod];
            freq[mod]++;
        }
        return count;
    }
}