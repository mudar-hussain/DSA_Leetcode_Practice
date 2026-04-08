class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] prefix = new int[n];
        Arrays.fill(prefix, 1);
        int res = n;
        for(int i = 1; i<n; i++){
            if(ratings[i-1]<ratings[i]){
                res -= prefix[i];
                prefix[i] = prefix[i-1]+1;
                res += prefix[i];
            }
        }
        for(int i = n-2; i>=0; i--){
            if(ratings[i+1]<ratings[i]) {
                if(prefix[i+1]>=prefix[i]) {
                    res -= prefix[i];
                    prefix[i] = prefix[i+1]+1;
                    res += prefix[i];
                }
            }
        }
        return res;
        
    }
}