class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        int a = -1, b = -1, c = -1;
        int right = 0;
        int count = 0;
        while(right<n) {
            if(s.charAt(right) == 'a') a=right;
            else if(s.charAt(right) == 'b') b=right;
            else if(s.charAt(right) == 'c') c=right;
            count += Math.min(a, Math.min(b,c))+1;
            right++;
        }
        return count;
        
    }
}