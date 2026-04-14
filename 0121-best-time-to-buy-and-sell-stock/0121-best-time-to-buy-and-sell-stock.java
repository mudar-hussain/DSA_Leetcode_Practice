class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i: prices){
            maxProfit = Math.max(maxProfit, i-minPrice);
            minPrice = Math.min(minPrice, i);
        }
        return maxProfit;
    }
}