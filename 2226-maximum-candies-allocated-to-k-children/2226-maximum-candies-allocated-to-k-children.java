class Solution {
    private boolean isPossible(int[] candies, long k, int divisor) {
        long childrens = 0;
        for(int c: candies) {
            childrens += c/divisor;
            if(childrens>=k) return true;
        }
        return false;
    }
    public int maximumCandies(int[] candies, long k) {
        int low = 1, high = Arrays.stream(candies).max().getAsInt();
        int ans = 0;
        while(low <= high) {
            int mid = low + (high-low)/2;
            if(isPossible(candies, k, mid)) {
                ans = mid;
                low = mid+1;
            } else high = mid-1;
        }
        return ans;
    }
}