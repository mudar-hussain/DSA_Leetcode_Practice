class Solution {
    public String makeGood(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            if(!st.isEmpty() && Math.abs(st.peek()-c)==32){
                st.pop();
            } else st.push(c);
        }
        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()) {
            res.append(st.pop());
        }
        return res.toString();
    }
}