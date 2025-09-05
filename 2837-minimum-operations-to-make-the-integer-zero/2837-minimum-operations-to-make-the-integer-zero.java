class Solution {
    public int makeTheIntegerZero(int num1, int num2) {
        for (long k = 0; k <= 60; ++k) {
            long T = (long) num1 - k * (long) num2;
            if (T < 0) continue;                 // can't sum to a negative
            int bits = Long.bitCount(T);
            if (bits <= k && k <= T) return (int) k;
        }
        return -1;
    }
}