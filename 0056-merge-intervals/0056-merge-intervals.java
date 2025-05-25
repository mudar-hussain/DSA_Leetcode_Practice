class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 1) return intervals;
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));
        int l = 0;
        int r = 1;
        while(r<intervals.length){
            if(intervals[l][1]>=intervals[r][0]){
                intervals[l][1] = Math.max(intervals[r][1], intervals[l][1]);
            } else {
                l++;
                intervals[l][0] = intervals[r][0];
                intervals[l][1] = intervals[r][1];
            }
            r++;
        }
        l++;
        int[][] ans = new int[l][2];
        for(int i = 0; i<l; i++) {
            ans[i][0] = intervals[i][0];
            ans[i][1] = intervals[i][1];
        }
        return ans;
    }
}