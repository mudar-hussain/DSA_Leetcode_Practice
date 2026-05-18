class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[] prefix = new int[n];
        int[] suffix = new int[n];
        int prev = height[0];
        for(int i = 1; i<n; i++){
            prev = Math.max(prev, height[i]);
            prefix[i] = prev;
        }
        prev = height[n-1];
        for(int i = n-2; i>=0; i--){
            prev = Math.max(prev, height[i]);
            suffix[i] = prev;
        }
        int res = 0;
        for(int i = 1; i<n-1; i++){
            System.out.println(Math.min(prefix[i], suffix[i]));
            res += (Math.min(prefix[i], suffix[i]) - height[i]);
        }
        return res;
        
    }
}