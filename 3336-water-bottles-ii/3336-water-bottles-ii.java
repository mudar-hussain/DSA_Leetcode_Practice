class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int ans = 0;
        int emptyBottles = 0;
        while(numBottles>0) {
            ans += numBottles;
            emptyBottles += numBottles;
            numBottles = 0;
            while(emptyBottles >= numExchange) {
                numBottles++;
                emptyBottles -= numExchange;
                numExchange++;
            }
        }
        return ans;
    }
}