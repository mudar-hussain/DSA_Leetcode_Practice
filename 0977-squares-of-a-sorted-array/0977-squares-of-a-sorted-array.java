class Solution {
    public int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        int left = 0;
        int right = n-1;
        int idx = n-1;
        while(left<=right) {
            int leftSq = nums[left]*nums[left];
            int rightSq = nums[right]*nums[right];
            if(leftSq>rightSq){
                res[idx] = leftSq;
                left++;
            } else {
                res[idx] = rightSq;
                right--;
            }
            idx--;
        }
        return res;
    }
}