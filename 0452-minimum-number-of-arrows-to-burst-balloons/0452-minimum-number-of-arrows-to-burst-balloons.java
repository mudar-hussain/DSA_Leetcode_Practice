class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        int arrowPos = 0;
        int arrows = 0;
        for(int[] p: points) {
            if(arrows==0 || p[0]>arrowPos) {
                arrows++;
                arrowPos = p[1];
            }
        }
        return arrows;
    }
}