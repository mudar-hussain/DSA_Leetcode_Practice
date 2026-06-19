class Solution {
    public String decodeString(String s) {
        Stack<Integer> numSt = new Stack<>();
        Stack<String> strSt = new Stack<>();
        StringBuilder res = new StringBuilder();
        int num = 0;
        for(char c: s.toCharArray()) {
            if(Character.isDigit(c)) {
                num = num*10 + (c-'0');
            } else if (c == '[') {
                strSt.push(res.toString());
                res.setLength(0);
                numSt.push(num);
                num = 0;
            } else if (c == ']') {
                int repeat = numSt.pop();
                StringBuilder repeated = new StringBuilder(strSt.pop());
                while(repeat>0) {
                    repeated.append(res);
                    repeat--;
                }
                res = repeated;
            } else {
                res.append(c);
            }
        }
        return res.toString();
    }
}