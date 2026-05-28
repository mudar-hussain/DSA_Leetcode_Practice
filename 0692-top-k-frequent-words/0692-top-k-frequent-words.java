class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> freq = new HashMap<>();
        for(String s: words) {
            freq.put(s, freq.getOrDefault(s, 0)+1);
        }
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a,b) -> a.getValue()==b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue()-a.getValue()
        );
        pq.addAll(freq.entrySet());
        List<String> result = new ArrayList<>();
        while(k-->0) {
            result.add(pq.poll().getKey());
        }
        return result;
        
    }
}