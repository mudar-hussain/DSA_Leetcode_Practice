class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Long, Integer> freq = new HashMap<>();
        long sumLength = 0;
        int maxIntersection = 0;
        for(List<Integer> list: wall){
            sumLength = 0;
            for(int i= 0; i<list.size()-1; i++){
                sumLength += list.get(i);
                int updatedFreq = freq.getOrDefault(sumLength,0)+1;
                freq.put(sumLength, updatedFreq);
                if(updatedFreq>maxIntersection) 
                    maxIntersection = updatedFreq;
            }
        }
        return wall.size()-maxIntersection;
        
    }
}