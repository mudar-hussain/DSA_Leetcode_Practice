class Solution {
    public double separateSquares(int[][] squares) {
        double totalArea = 0;
        double low = Double.MAX_VALUE;
        double high = 0;
        for(int[] sq: squares) {
            int y = sq[1];
            int l = sq[2];
            totalArea += (double)l*l;
            low = Math.min(low, y);
            high = Math.max(high, y+l);
        }
        double halfArea = totalArea / 2.0;
        for(int i = 0; i<100; i++) {
            double mid = low + (high - low) / 2.0;
            double calcArea = calculateArea(squares, mid);
            if (calcArea >= halfArea) {
                high = mid;
            } else low = mid;
            
        }
        return high;
    }
    private double calculateArea(int[][] squares, double currY) {
        double area = 0;
        for(int[] sq: squares) {
            double y = sq[1];
            double l = sq[2];
            double top = y+l;
            if(y>=currY) continue;
            else if (top<=currY) {
                area += (double)l*l;
            } else {
                area += l*(currY-y);
            }
        }
        return area;
    }
}