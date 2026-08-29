class Solution {
    public int maxVowels(String s, int k) {
        int res = 0;
        int vowels = 0;
        int left = 0, right = 0;
        while(right<s.length()) {
            if(right>=k && "aeiou".indexOf(s.charAt(left++)) >=0) {
                vowels--;
            }
            if("aeiou".indexOf(s.charAt(right++))>=0) {
                vowels++;
            }
            res = Math.max(res, vowels);
            if(res == k) break;
        }
        return res;
    }
}