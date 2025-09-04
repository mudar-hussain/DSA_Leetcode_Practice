class Solution {
    public boolean isPalindrome(int x) {
        if(x<0) return false;
        int xOriginal = x;
        int palindrome = 0;
        while(x>0) {
            palindrome = palindrome * 10 + x%10;
            x = x/10;
        }
        return palindrome == xOriginal;
    }
}