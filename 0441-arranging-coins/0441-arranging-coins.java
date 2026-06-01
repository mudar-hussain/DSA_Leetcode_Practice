class Solution {
    public int arrangeCoins(int n) {
        int count = 1;
        while(n>0) {
            n -= count;
            if(n>=0) count++;
        }
        return count-1;
        
    }
}