class Solution {
    public int countDays(int days, int[][] meetings) {
        Arrays.sort(meetings, (a,b) -> a[0]-b[0]);
        int end = 0;
        int res = 0;
        for(int i = 0; i<meetings.length; i++) {
            if(meetings[i][0]-end>1) res += meetings[i][0]-end-1;
            end = Math.max(end, meetings[i][1]);
        }
        res += days-end;
        return res;
    }
}