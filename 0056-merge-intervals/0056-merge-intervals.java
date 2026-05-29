class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0]));
        int start = intervals[0][0];
        int end = intervals[0][1];
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i<intervals.length; i++){
            if(end>=intervals[i][0]) end = Math.max(end, intervals[i][1]);
            else {
                list.add(Arrays.asList(start, end));
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        list.add(Arrays.asList(start, end));
        int[][] result = new int[list.size()][2];
        int k = 0;
        for(List<Integer> l: list){
            result[k][0] = l.get(0);
            result[k][1] = l.get(1);
            k++;
        }
        return result;
    }
}