class Solution {
    private boolean isPossible(int[] houses, int[] heaters, int radius) {
        int j = 0;
        for(int i = 0; i<houses.length; i++) {
            while(j<heaters.length) {
                if(Math.abs(houses[i]-heaters[j])<=radius) break;
                else j++;
            }
            if(j==heaters.length) return false;
        }
        return true;
    }
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);

        int low = 0;
        int high = Math.max(Math.abs(Arrays.stream(houses).max().getAsInt()-Arrays.stream(heaters).min().getAsInt()),Math.abs(Arrays.stream(houses).min().getAsInt()-Arrays.stream(heaters).max().getAsInt()));
        while(low<high) {
            int mid = low + (high - low)/2;
            if(isPossible(houses, heaters, mid)) {
                high = mid;
            } else low = mid + 1;
        }
        return high;
    }
}