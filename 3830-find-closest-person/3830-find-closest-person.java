class Solution {
    public int findClosest(int x, int y, int z) {
        int diff1 = z>x ? z-x : x-z;
        int diff2 = z>y ? z-y : y-z;
        return diff1<diff2 ? 1 : diff1>diff2 ? 2 : 0;
    }
}