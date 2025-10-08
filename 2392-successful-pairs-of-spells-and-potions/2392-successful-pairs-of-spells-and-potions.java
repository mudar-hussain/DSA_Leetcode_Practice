class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] ans = new int[n];
        Arrays.sort(potions);
        for (int i = 0; i<n; i++) {
            int idx = bs(spells[i], potions, success);
            if (idx!=-1) ans[i] = m-idx;
        }
        return ans;
    }
    private int bs(long spell, int[] potions, long success) {
        int low = 0, high = potions.length-1, idx = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if ((long) potions[mid] * spell >= success) {
                idx = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        return idx;
    }
}