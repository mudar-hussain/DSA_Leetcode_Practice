class Solution {
    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        Map<Integer, Long> map = new HashMap<>();
        map.put(0, 1L); // important base case

        long count = 0;
        int prefix = 0;

        for (int num : nums) {
            // convert to 0/1
            if (num % modulo == k) {
                prefix++;
            }

            int currMod = prefix % modulo;

            // we need previous prefix with:
            int needed = (currMod - k + modulo) % modulo;

            count += map.getOrDefault(needed, 0L);

            map.put(currMod, map.getOrDefault(currMod, 0L) + 1);
        }

        return count;
    }
}