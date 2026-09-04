class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        
        int n = answerKey.length();
        int left = 0, right = 0, count = 0, t = 0, f = 0;
        while(right<n) {
            if(answerKey.charAt(right) == 'T') t++;
            else f++;
            if(Math.min(t,f) <= k) {
                count = Math.max(count, right-left+1);
            }
            while(left<=right && Math.min(t,f) > k) {
                if(answerKey.charAt(left++) == 'T') t--;
                else f--;
            }
            if(Math.min(t,f) <= k) {
                count = Math.max(count, right-left+1);
            }
            right++;
        }
        return count;
    }
}