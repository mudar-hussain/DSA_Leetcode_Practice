class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        List<Integer> res = new ArrayList<>();
        if(tomatoSlices%2 != 0 || tomatoSlices<cheeseSlices*2) return res;
        int jumbo = tomatoSlices / 4;
        tomatoSlices = tomatoSlices % 4;
        int small = tomatoSlices / 2;
        while(jumbo + small < cheeseSlices) {
            jumbo--;
            small+=2;
        }
        if(jumbo+small>cheeseSlices) return res;
        else {
            res.add(jumbo);
            res.add(small);
        }
        return res;
        
    }
}