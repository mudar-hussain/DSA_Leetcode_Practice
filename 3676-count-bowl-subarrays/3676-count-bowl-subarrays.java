class Solution {
    public long bowlSubarrays(int[] nums) {
        int n = nums.length;
        long res = 0;
        if(n<3) return res;
        int[] nextGreater = findNextGreater(nums);
        int[] prevGreater = findPrevGreater(nums);
        for(int start = 0; start<n; start++) {
            int end = nextGreater[start];
            if(end!=-1 && (end-start+1)>=3) {
                res++;
            }
        }
        for(int end = 0; end<n; end++) {
            int start = prevGreater[end];
            if(start != -1 && (end-start+1)>=3) {
                res++;
            }
        }
        return res;

        
    }
    private int[] findNextGreater(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = 0; i<n; i++) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        return res;
    }
    private int[] findPrevGreater(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int[] res = new int[n];
        Arrays.fill(res, -1);
        for(int i = n-1; i>=0; i--) {
            while(!st.isEmpty() && nums[st.peek()] < nums[i]) {
                res[st.pop()] = i;
            }
            st.push(i);
        }
        return res;

    }
}