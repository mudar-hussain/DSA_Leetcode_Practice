class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i: asteroids) {
            boolean alive = true;
            while(!st.isEmpty() && alive && i<0 && st.peek()>0){
                if(st.peek()<-i) {
                    st.pop();
                } else if (st.peek()==-i) {
                    st.pop();
                    alive = false;
                } else {
                    alive = false;
                }
            }
            if(alive){
                st.push(i);
            }
        }
        int[] ans = new int[st.size()];
        int i = st.size()-1;
        while(!st.isEmpty()) {
            ans[i--] = st.pop(); 
        }
        return ans;
    }
}