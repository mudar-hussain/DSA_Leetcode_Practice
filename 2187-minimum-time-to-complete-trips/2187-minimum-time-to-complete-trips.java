class Solution {
    private boolean areTripsCompleted(int[] time, long currentTime, int totalTrips) {
        long trips = 0;
        for(int t: time) {
            trips += currentTime / t;
            if(trips>=totalTrips) return true;
        }
        return false;
    }
    public long minimumTime(int[] time, int totalTrips) {
        int minTime = Arrays.stream(time).min().getAsInt();
        long low = 1, high = (long)minTime * totalTrips;
        while(low<high) {
            long mid = low + (high-low)/2;
            if(areTripsCompleted(time, mid, totalTrips)) {
                high = mid;
            } else low = mid + 1;
        }
        return high;
        
    }
}