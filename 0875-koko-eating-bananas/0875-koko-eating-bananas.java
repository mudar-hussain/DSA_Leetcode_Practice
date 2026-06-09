class Solution {
    private boolean isEaten(int[] piles, int speed, int totalTime) {
        int time = 0;
        for(int pile: piles) {
            time += pile/speed;
            if(pile%speed > 0) time++;
            if(time>totalTime) return false;
        }
        return true;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int low = 1, high = Arrays.stream(piles).max().getAsInt();
        while(low<high) {
            int mid = low + (high-low)/2;
            if(isEaten(piles, mid, h)){
                high = mid;
            } else low = mid + 1;
        }
        return high;
    }
}