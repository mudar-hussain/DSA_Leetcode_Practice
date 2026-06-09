class Solution {
    private int  upperBound(int[][] items, int time) {
        int low = 0, high = items.length-1;
        int ans = -1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(items[mid][0]<=time) {
                ans = mid;
                low = mid+1;
            } else high = mid-1;
        }
        return ans == -1 ? 0 : items[ans][1];
    }
    public int[] maximumBeauty(int[][] items, int[] queries) {
        Arrays.sort(items, (a,b) -> a[0]==b[0] ? Integer.compare(b[1], a[1]) : Integer.compare(a[0], b[0]));
        int maxBeauty = 0;
        for(int[] item: items) {
            maxBeauty = Math.max(maxBeauty, item[1]);
            item[1] = maxBeauty;
        }

        int[] res = new int[queries.length];
        for(int i = 0; i<queries.length; i++) {
            res[i] =  upperBound(items, queries[i]);
        }
        return res;
        
    }
}