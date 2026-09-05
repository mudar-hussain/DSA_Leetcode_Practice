class Solution {
    public int totalFruit(int[] fruits) {
        int[] freq = new int[fruits.length];
        int left = 0, distinct = 0;
        int maxFruits = 0;
        for(int right = 0; right<fruits.length; right++) {
            freq[fruits[right]]++;
            if(freq[fruits[right]] == 1) {
                distinct++;
            }
            while(left<right && distinct > 2) {
                freq[fruits[left]]--;
                if(freq[fruits[left++]] == 0) {
                    distinct--;
                }
            }
            maxFruits = Math.max(maxFruits, right-left+1);
        }
        return maxFruits;
    }
}