class Solution {
    public int[] platesBetweenCandles(String s, int[][] queries) {
        int m = queries.length;
        int[] res = new int[m];
        int[] plates = new int[s.length()];
        int[] candleLeft = new int[s.length()];
        int[] candleRight = new int[s.length()];
        int count = 0;
        int candleLeftIdx = -1;
        int candleRightIdx = -1;
        for(int i = 0; i<s.length(); i++){
            if(s.charAt(i) == '*') count++;
            plates[i] = count;
            if(s.charAt(i) == '|') candleLeftIdx = i;
            candleLeft[i] = candleLeftIdx;
        }
        for(int i = s.length()-1; i>=0; i--){
            if(s.charAt(i) == '|') candleRightIdx = i;
            candleRight[i] = candleRightIdx;
        }
        for(int i = 0; i<m; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            if(candleLeft[right] == -1 || candleRight[left] == -1) {
                res[i] = 0;
            } else {
                count = plates[candleLeft[right]] - plates[candleRight[left]];
                res[i] = count<0?0:count;
            }
            // while(left<right){
            //     if (s.charAt(left) == '*') left++;
            //     if (s.charAt(right) == '*') right--;
            //     if (s.charAt(left) == '|' && s.charAt(right) == '|') {
            //         res[i] = plates[right] - plates[left];
            //         break;
            //     }
            // }
        }
        return res;
    }
}