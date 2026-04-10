class Solution {
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        List<String> res = new ArrayList<>();
        if(n==0) return res;
        int start = nums[0];
        int end = nums[0];
        for(int i = 1; i<n; i++){
            if(nums[i] == end+1) {
                end = nums[i];
            } else {
                String st = start<end ? String.valueOf(start) + "->" + String.valueOf(end) : String.valueOf(start);
                res.add(st);
                start = nums[i];
                end = nums[i];
            }
        }
        String st = start<end ? String.valueOf(start) + "->" + String.valueOf(end) : String.valueOf(start);
        res.add(st);
        
        return res;
        
    }
}