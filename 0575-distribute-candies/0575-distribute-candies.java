class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i<candyType.length; i++){
            set.add(candyType[i]);
            if(set.size()>candyType.length/2) return candyType.length/2;
        }
        
        return Math.min(set.size(), candyType.length/2);
    }
}