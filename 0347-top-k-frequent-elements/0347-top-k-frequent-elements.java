class Solution {
    class Pair {
        int val;
        int freq;
        public Pair(int val, int freq){
            this.val = val;
            this.freq = freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Queue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq-a.freq);
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[k];
        for(int num: nums) {
            map.put(num, map.getOrDefault(num,0)+1);
        }
        for(int key: map.keySet()) {
            pq.offer(new Pair(key, map.get(key)));
        }
        for(int i = 0; i<k; i++) {
            res[i] = pq.poll().val;
        }
        return res;

        
    }
}