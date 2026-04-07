class Solution {
    public long[] distance(int[] nums) {
        int n = nums.length;
        long[] prefixSum = new long[n];
        int[] prefixCount = new int[n];
        long[] suffixSum = new long[n];
        int[] suffixCount = new int[n];
        Map<Integer, Long> sum = new HashMap<>();
        Map<Integer, Integer> count = new HashMap<>();
        long[] res = new long[n];

        for(int i = 0; i<n; i++){
            long newSum = sum.getOrDefault(nums[i], 0L);
            int newCount = count.getOrDefault(nums[i], 0);

            prefixSum[i] = newSum;
            prefixCount[i] = newCount;

            sum.put(nums[i], newSum+(long)i);
            count.put(nums[i], newCount+1);
        }

        sum.clear();
        count.clear();

        for(int i = n-1; i>=0; i--){
            long newSum = sum.getOrDefault(nums[i], 0L);
            int newCount = count.getOrDefault(nums[i], 0);

            suffixSum[i] = newSum;
            suffixCount[i] = newCount;

            sum.put(nums[i], newSum+(long)i);
            count.put(nums[i], newCount+1);
        }
        for(int i = 0; i<n; i++) {
            res[i] = (long)i*prefixCount[i]-prefixSum[i] + suffixSum[i]-(long)i*suffixCount[i];
        }
        return res;
        
    }
}