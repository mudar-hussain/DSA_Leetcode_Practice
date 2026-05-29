class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[1], b[1]));
        int end = intervals[0][1];
        int count = 1;
        for(int i = 1; i<intervals.length; i++) {
            if(end<=intervals[i][0]) {
                end = intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;
    }
}