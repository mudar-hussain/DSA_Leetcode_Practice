class Solution {
    public String mergeAlternately(String word1, String word2) {
        String merged = "";
        int i = 0;
        for(; i<word1.length() && i<word2.length(); i++){
            merged += word1.charAt(i);
            merged += word2.charAt(i);
        }
        
        for(; i<word1.length(); i++){
            merged += word1.charAt(i);
        }
        
        for(; i<word2.length(); i++){
            merged += word2.charAt(i);
        }

        return merged;
        
    }
}