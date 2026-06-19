class Solution {
    public String simplifyPath(String path) {
        String[] str = path.split("/");
        Stack<String> st = new Stack<>();
        for(String s: str) {
            if(s.length()==0 || s.equals(".")) continue;
            else if(s.equals("..")) {
                if(!st.isEmpty()) st.pop();
            } else {
                st.push(s);
            } 
        }
        StringBuilder res = new StringBuilder();
        for(String s: st) {
            res.append("/");
            res.append(s);
        }
        return res.length()==0? "/" : res.toString();
    }
}