class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int[] freq = new int[3];
        int left = 0, right = 0;
        int count = 0;
        while(right<n) {
            freq[s.charAt(right) - 'a']++;
            while(freq[0]>0 && freq[1]>0 && freq[2]>0) {
                count += n-right;
                freq[s.charAt(left++) - 'a']--;
            }
            right++;
        }
        return count;
    }
}