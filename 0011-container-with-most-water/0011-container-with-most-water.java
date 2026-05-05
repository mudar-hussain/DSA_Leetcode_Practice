class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = Integer.MIN_VALUE;
        while(left<right){
            res = Math.max(res, Math.abs(left-right) * Math.min(height[left],height[right]));
            if(height[left]<height[right]) left++;
            else right--;
        }
        return res;
        
    }
}