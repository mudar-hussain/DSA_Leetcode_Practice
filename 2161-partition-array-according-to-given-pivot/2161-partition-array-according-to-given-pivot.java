class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        Stack<Integer> less = new Stack<>();
        Stack<Integer> more = new Stack<>();
        int pivotCount = 0;
        for(int i: nums) {
            if(i<pivot) {
                less.push(i);
            } else if(i>pivot) {
                more.push(i);
            } else {
                pivotCount++;
            }
        }
        int[] ans = new int[nums.length];
        int i = less.size()-1+pivotCount;
        
        while(pivotCount-->0) {
            ans[i--] = pivot;
        }
        while(!less.isEmpty()) {
            ans[i--] = less.pop();
        }
        i = nums.length-1;
        while(!more.isEmpty()) {
            ans[i--] = more.pop();
        }
        return ans;
    }
}