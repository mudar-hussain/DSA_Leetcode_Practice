class Solution {
    public int numberOfPairs(int[][] points) {
        Arrays.sort(points, (a,b) -> a[0]==b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int n = points.length;
        int count = 0;

        for (int i = 0; i<n; i++) { //A
            int yi = points[i][1];
            int prevY = Integer.MIN_VALUE;
            for (int j = i+1; j<n; j++) { //B
                int yj = points[j][1];
                if(yi >= yj && yj > prevY) {
                    count++;
                    prevY = yj;
                }
            }
        }
        return count;
    }
}