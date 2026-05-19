class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if(tomatoSlices%2 != 0) return res;
        int x = tomatoSlices/2 - cheeseSlices;
        int y = cheeseSlices - x;
        if(x<0 || y<0) return res;
        return Arrays.asList(x, y);
        
    }
}