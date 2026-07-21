class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        int res = 0;
        Queue<Integer> q = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        q.offer(start);
        while(!q.isEmpty()) {
            int size = q.size();
            while(size-->0) {
                int x = q.poll();
                if(x==goal) return res;
                if((x<0 || x>1000) || set.contains(x)) continue;
                if(!set.contains(x)) set.add(x);
                for(int num: nums) {
                    q.offer(x+num);
                    q.offer(x-num);
                    q.offer(x^num);
                }
            }
            res++;
        }
        return -1;
    }
}