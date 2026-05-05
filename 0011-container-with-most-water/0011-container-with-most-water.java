class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length-1;
        int res = Integer.MIN_VALUE;
        while(left<right){
            int min = Math.min(height[left],height[right]);
            res = Math.max(res, Math.abs(left-right) * min);
            while(left<right && height[left]<=min) left++;
            while(left<right && height[right]<=min) right--;
        }
        return res;
        
    }
}