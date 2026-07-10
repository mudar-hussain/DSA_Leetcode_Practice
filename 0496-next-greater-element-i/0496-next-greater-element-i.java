class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[10001];
        for(int i = nums2.length-1; i>=0; i--) {
            while(!st.isEmpty() && st.peek()<=nums2[i]) {
                st.pop();
            }
            nextGreater[nums2[i]] = st.isEmpty() ? -1 : st.peek();
            st.push(nums2[i]);
        }
        int[] ans = new int[nums1.length];
        for(int i = 0; i<nums1.length; i++) {
            ans[i] =nextGreater[nums1[i]];
        }
        return ans;
    }
}