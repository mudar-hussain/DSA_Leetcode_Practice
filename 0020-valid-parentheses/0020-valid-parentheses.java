class Solution {
    private boolean isPair(char start, char end) {
        if((start=='(' && end==')') || (start=='{' && end=='}') || (start=='[' && end==']')) {
            return true;
        } else return false;
    }
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0; i<s.length(); i++) {
            char c = s.charAt(i);
            if(c == '(' || c=='{' || c=='[') {
                st.push(c);
            } else {
                if(st.isEmpty()) return false;
                else if(isPair(st.peek(), c)){
                    st.pop();
                } else return false;
            }
        }
        return st.isEmpty();
    }
}