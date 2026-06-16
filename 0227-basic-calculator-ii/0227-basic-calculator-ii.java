class Solution {
    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();
        int num = 0;
        s += '+';
        char op = '+';
        for(char c:s.toCharArray()) {
            if(c==' ') continue;
            if(Character.isDigit(c)) {
                num = num*10 + (c-'0');
                continue;
            }
            if(op=='+') st.push(num);
            if(op=='-') st.push(-num);
            if(op=='*') st.push(st.pop()*num);
            if(op=='/') st.push(st.pop()/num);
            op = c;
            num = 0;
        }
        for(int n: st) {
            num += n;
        }
        return num;
    }
}