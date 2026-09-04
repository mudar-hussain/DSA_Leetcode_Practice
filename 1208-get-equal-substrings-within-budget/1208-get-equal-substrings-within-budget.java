class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int n = s.length();
        int left = 0, right = 0;
        int res = 0, currCost = 0;
        while(right< n) {
            currCost += Math.abs(s.charAt(right) - t.charAt(right));
            while(left<=right && currCost > maxCost) {
                currCost -= Math.abs(s.charAt(left) - t.charAt(left));
                left++;
            }
            res = Math.max(res, right-left+1);
            right++;
        }
        return res;
    }
}