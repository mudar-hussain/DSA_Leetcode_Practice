class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int n = trips.length;
        int[] diff = new int[1001];
        for(int[] trip: trips){
            int numPassenger = trip[0];
            int i = trip[1];
            int j = trip[2];
            diff[i] += numPassenger;
            diff[j] -= numPassenger;
        }
        for(int i = 0; i<1001; i++) {
            if(i>0) diff[i] += diff[i-1];
            if(diff[i] > capacity) return false;
        }
        return true;
        
    }
}