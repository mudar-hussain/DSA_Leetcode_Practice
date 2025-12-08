class Solution {
    public int countTriples(int n) {
        int count = 0;
        while(n>=5) {
            for (int i = 2; i<n; i++) {
                double sqrt = Math.sqrt(n*n - i*i);
                if (sqrt == Math.floor(sqrt) && sqrt<n){
                    count++;
                }
            }
            n--;
        }
        return count;
    }
}