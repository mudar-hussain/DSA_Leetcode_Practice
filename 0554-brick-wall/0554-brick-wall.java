class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        long totalLength = 0;
        for(int i: wall.get(0)){
            totalLength+=i;
        }
        Map<Long, Integer> freq = new HashMap<>();
        long sumLength = 0;
        int maxIntersection = 0;
        int singleBrick = 0;
        for(List<Integer> list: wall){
            sumLength = 0;
            for(long i: list){
                if(i == totalLength) singleBrick++;
                sumLength += i;
                int updatedFreq = freq.getOrDefault(sumLength,0)+1;
                freq.put(sumLength, updatedFreq);
                if(sumLength<totalLength && updatedFreq>maxIntersection) 
                    maxIntersection = updatedFreq;
            }
        }
        return singleBrick == wall.size() ? singleBrick : wall.size()-maxIntersection;
        
    }
}