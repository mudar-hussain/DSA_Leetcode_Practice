class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder mergedWord = new StringBuilder();
        int i = 0;
        for(i = 0; i<word1.length() && i<word2.length(); i++) {
            mergedWord.append(word1.charAt(i));
            mergedWord.append(word2.charAt(i));
        }
        for(; i<word1.length(); i++) {
            mergedWord.append(word1.charAt(i));
        }
        for(; i<word2.length(); i++) {
            mergedWord.append(word2.charAt(i));
        }
        return mergedWord.toString();
    }
}