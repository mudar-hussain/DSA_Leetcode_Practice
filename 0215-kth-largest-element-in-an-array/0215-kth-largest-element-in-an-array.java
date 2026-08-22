class Solution {
    Queue<Integer> pq = new PriorityQueue<>();
    int k = 0;
    
    public void add(int val) {
        if(pq.size()==this.k) {
            pq.offer(Math.max(val, pq.poll()));
        } else {
            pq.offer(val);
        }       
    }
    public int findKthLargest(int[] nums, int k) {
        this.k = k;
        for(int i: nums) {
            add(i);
        }
        return pq.peek();
    }

}