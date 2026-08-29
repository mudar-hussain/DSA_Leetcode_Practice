class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length()) return false;
        int left = 0, right = 0;
        int[] freq = new int[26];
        boolean isValid = true;
        while(right<s2.length()) {
            if(right<s1.length()) {
                freq[s1.charAt(right)-'a']++;
                freq[s2.charAt(right++)-'a']--;
            } else {
                freq[s2.charAt(left++)-'a']++;
                freq[s2.charAt(right++)-'a']--;
            }
            if(right>=s1.length()) {
                isValid = true;
                for(int i: freq) {
                    if(i!=0) {
                        isValid = false;
                        break;
                    }
                }
                if(isValid) return true;
            }
            
        }
        return false;
        
    }
}