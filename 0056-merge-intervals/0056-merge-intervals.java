class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<int[]> merged = new ArrayList<>();
        for(int i = 1; i<intervals.length; i++){
            if(end>=intervals[i][0]) end = Math.max(end, intervals[i][1]);
            else {
                merged.add(new int[]{start, end});
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        merged.add(new int[]{start, end});
        return merged.toArray(new int[merged.size()][]);
    }
}