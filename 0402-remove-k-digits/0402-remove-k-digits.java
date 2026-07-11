class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if(n==k) return "0";
        Stack<Character> st = new Stack<>();
        for(char c: num.toCharArray()) {
            while(k>0 && !st.isEmpty() && st.peek()>c) {
                st.pop();
                k--;
            }
            if(c=='0' && st.isEmpty()) continue;
            st.push(c);
        }
        StringBuilder value = new StringBuilder();
        while(!st.isEmpty()) {
            Character ch = st.pop();
            if(k>0) {
                k--;
            } else {
                value.append(ch);
            }
            
        }
        String ans = value.reverse().toString();
        return ans.length()>0 ? ans : "0";
    }
}