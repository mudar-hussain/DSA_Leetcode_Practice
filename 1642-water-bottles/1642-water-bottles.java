class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = 0;
        int carry = 0;
        while (numBottles>0) {
            ans += numBottles;
            numBottles += carry;
            carry = numBottles%numExchange;
            numBottles /= numExchange;
        }
        return ans;
        
    }
}