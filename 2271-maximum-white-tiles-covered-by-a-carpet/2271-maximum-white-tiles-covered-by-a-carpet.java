class Solution {
    public int maximumWhiteTiles(int[][] tiles, int carpetLen) {
        Arrays.sort(tiles, (a,b) -> Integer.compare(a[0], b[0]));

        int result = 0, covered = 0, startIdx = 0;
        for(int endIdx = 0; result<carpetLen && endIdx<tiles.length; ) {
            if(startIdx == endIdx || tiles[endIdx][1] < tiles[startIdx][0] + carpetLen) {
                covered += Math.min(carpetLen, tiles[endIdx][1] - tiles[endIdx][0] + 1);
                result = Math.max(result, covered);
                endIdx++;
            } else {
                int partial = Math.max(0, tiles[startIdx][0] + carpetLen - tiles[endIdx][0]);
                result = Math.max(result, covered+partial);
                covered -= tiles[startIdx][1] - tiles[startIdx][0] + 1;
                startIdx++;
            }
        }
        return result;
    }
}