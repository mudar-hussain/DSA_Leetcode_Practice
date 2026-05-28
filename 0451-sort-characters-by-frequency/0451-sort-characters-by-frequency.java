class Solution {
    public String frequencySort(String s) {
        int[] freq = new int[128];
        for(char c: s.toCharArray()){
            freq[c]++;
        }
        char[] result = new char[s.length()];
        int idx = 0;
        while(idx<s.length()) {
            int maxFreq = 0;
            int maxChar = 'a';
            for(int i = 0; i<128; i++) {
                if(freq[i]>maxFreq) {
                    maxFreq = freq[i];
                    maxChar = i;
                }
            }
            while(freq[maxChar]-->0){
                result[idx++] = (char)maxChar;
            }
        } 
        return new String(result);
    }
}