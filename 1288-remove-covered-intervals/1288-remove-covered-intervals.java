class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]));
        int count = 1;
        int max = intervals[0][1];
        for(int[] interval: intervals) {
            if(interval[1] > max) {
                count++;
                max = interval[1];
            }
        }
        return count;
    }
}