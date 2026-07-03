class Solution {
    public int minAddToMakeValid(String s) {
        int length = s.length();
        StringBuilder res = new StringBuilder();
        int symbolCounter = 0;
        for(char c: s.toCharArray()) {
            if(c>='a' && c<='z') res.append(c);
            else if(c=='(') {
                symbolCounter++;
                res.append(c);
            } else if(c==')') {
                if(symbolCounter != 0) {
                    res.append(c);
                    symbolCounter--;
                }   
            }
        }
        s = res.toString();
        res.setLength(0);
        symbolCounter = 0;
        for(int i = s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if(c>='a' && c<='z') res.append(c);
            else if(c==')') {
                symbolCounter++;
                res.append(c);
            } else if (c=='(') {
                if(symbolCounter != 0) {
                    res.append(c);
                    symbolCounter--;
                }   
            }
        }
        return length - res.length();
    }
}
