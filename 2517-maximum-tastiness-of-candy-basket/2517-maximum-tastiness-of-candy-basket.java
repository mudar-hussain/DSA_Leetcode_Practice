class Solution {
    private boolean isPossible(int[] price, int k, int target) {
        int last = price[0], count = 1, i = 1;
        while(count<k && i<price.length) {
            if(price[i]-last >= target) {
                last = price[i];
                count++;
            }
            i++;
        }
        return count == k;
    }
    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int low = 0, high = 1000000000;
        while(low<high) {
            int mid = low + (high-low)/2;
            if(isPossible(price, k, mid)) {
                low = mid+1;
            } else {
                high = mid;
            }
        }
        return low-1;
    }
}