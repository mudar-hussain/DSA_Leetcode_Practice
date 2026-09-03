class Solution {
    private boolean canAchieve(long[] power, int r, int k, long target) {
        int n = power.length;
        long[] extra = new long[n+1];
        long added = 0;
        long remaining = k;
        for(int i = 0;i<n; i++) {
            added += extra[i];
            long current = power[i] + added;
            if(current<target) {
                long need = target-current;
                if(need>remaining) return false;
                remaining -= need;
                added += need;
                int expire = Math.min(n, i+2*r+1);
                extra[expire] -= need;
            }
        }
        return true;
    }
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        long[] diff = new long[n+1];
        for(int i = 0;i<n; i++) {
            int left = Math.max(0, i-r);
            int right = Math.min(n-1, i+r);
            diff[left] += stations[i];
            if(right+1 < n+1) {
                diff[right+1] -= stations[i];
            }
        }
        power[0] = diff[0];
        for(int i = 1; i<n; i++) {
            power[i] = power[i-1] + diff[i];
        }
        long low = 0;
        long high = Arrays.stream(stations).asLongStream().sum() + k;
        while(low<high) {
            long mid = (low + high +1) / 2;
            if(canAchieve(power, r, k, mid)) {
                low = mid;
            } else {
                high = mid -1;
            }
        }
        return low;
    }

}