class Solution {
    List<String> res;
    public List<String> letterCasePermutation(String s) {
        res = new ArrayList<>();
        dfs(s, "", 0);
        return res;
    }
    private void dfs(String s, String curr, int idx) {
        if(idx>=s.length()){
            res.add(new String(curr));
            return;
        }
        char c = s.charAt(idx);

        if(c>='0' && c<='9') {
            dfs(s, curr+c, idx+1);
        } else {
            dfs(s, curr+Character.toLowerCase(c), idx+1);
            dfs(s, curr+Character.toUpperCase(c), idx+1);
        }

    }
}