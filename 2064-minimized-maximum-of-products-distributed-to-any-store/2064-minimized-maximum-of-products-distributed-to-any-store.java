class Solution {
    private boolean isPossible(int n, int[] quantities, int divisor) {
        int stores = 0;
        for(int q: quantities) {
            stores += (q+divisor-1)/divisor;
            if(stores>n) return false;
        }
        return true;
    }
    public int minimizedMaximum(int n, int[] quantities) {
        int low = 1, high = Arrays.stream(quantities).max().getAsInt();
        while(low<high) {
            int mid = low + (high-low)/2;
            if(isPossible(n, quantities, mid)) {
                high = mid;
            } else low = mid+1;
        }
        return high;
        
         
    }
}