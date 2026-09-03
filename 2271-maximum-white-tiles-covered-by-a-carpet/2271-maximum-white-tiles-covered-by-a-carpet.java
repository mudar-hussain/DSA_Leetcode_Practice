class Solution {
    int end = 1;
    int start = 0;
    int maximumWhiteTiles(int[][] tiles, int len) {
        int result = 0, startTileIndex = 0, covered = 0;

        Arrays.sort(tiles, Comparator.comparingInt(a -> a[0]));

        for (int endTileIndex = 0; result < len && endTileIndex < tiles.length; )
            if (startTileIndex == endTileIndex || tiles[startTileIndex][start] + len > tiles[endTileIndex][end]) {
                covered += Math.min(len, tiles[endTileIndex][end] - tiles[endTileIndex][start] + 1);
                result = Math.max(result, covered);
                ++endTileIndex;
            }
            else {
                int partial = Math.max(0, tiles[startTileIndex][start] + len - tiles[endTileIndex][start]);
                result = Math.max(result, covered + partial);
                covered -= (tiles[startTileIndex][end] - tiles[startTileIndex][start] + 1);
                ++startTileIndex;
            }

        return result;
    }
}