class Solution {
    private int romanIntLookUp(char ch){
        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
    public int romanToInt(String s) {

        int n = s.length();
        char prev = s.charAt(0);
        int value = romanIntLookUp(prev);
        for(int i = 1; i<n; i++) {
            char curr = s.charAt(i);
            if(romanIntLookUp(prev)<romanIntLookUp(curr)){
                value += (romanIntLookUp(curr)-2*romanIntLookUp(prev));
            } else {
                value += romanIntLookUp(curr);
            }
            prev = curr;
            
        }
        return value;    
    }
}