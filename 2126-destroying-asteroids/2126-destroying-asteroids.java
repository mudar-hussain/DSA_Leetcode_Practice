class Solution {
    public boolean asteroidsDestroyed(int mass, int[] asteroids) {
        Arrays.sort(asteroids);
        long prefix = mass*1L;
        for(int num: asteroids) {
            if(prefix<num) return false;
            prefix += num*1L;
        }
        return true;
    }
}