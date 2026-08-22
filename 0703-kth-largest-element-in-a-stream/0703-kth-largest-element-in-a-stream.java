class KthLargest {
    Queue<Integer> pq = new PriorityQueue<>();
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i: nums) {
            add(i);
        }
    }
    
    public int add(int val) {
        if(pq.size()==this.k) {
            pq.offer(Math.max(val, pq.poll()));
        } else {
            pq.offer(val);
        }
        return pq.peek();        
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */