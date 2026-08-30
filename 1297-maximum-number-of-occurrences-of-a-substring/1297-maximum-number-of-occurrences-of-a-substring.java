class Solution {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        int[] freq = new int[26];
        Map<String, Integer> map = new HashMap<>();
        int distinct = 0, ans = 0;
        for(int i = 0; i<s.length(); i++) {
            if(++freq[s.charAt(i)-'a'] == 1) distinct++;
            if(i>=minSize) {
                if(--freq[s.charAt(i-minSize)-'a'] == 0) distinct--;
            }
            if(i>=minSize-1 && distinct<=maxLetters) {
                String st = s.substring(i-minSize+1, i+1);
                ans = Math.max(ans, map.merge(st, 1, (a,b) -> a+b));
            }
        }
        return ans;
        
    }
}