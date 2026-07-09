class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] suffix = new int[n];
        int prev = height[n-1];
        for(int i = n-2; i>=0; i--){
            prev = Math.max(prev, height[i]);
            suffix[i] = prev;
        }
        prev = height[0];
        int res = 0;
        for(int i = 1; i<n-1; i++){
            prev = Math.max(prev, height[i]);
            res += (Math.min(prev, suffix[i]) - height[i]);
        }
        return res;
        
    }
}