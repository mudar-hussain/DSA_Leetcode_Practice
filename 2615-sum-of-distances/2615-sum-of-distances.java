class Solution {
    public long[] distance(int[] nums) {
        int n=nums.length;
        long res[]= new long[n];

        Map<Integer, List<Integer>> map= new HashMap<>();

        // step-1
        for(int i=0; i<n; i++){
            map.computeIfAbsent(nums[i], k->new ArrayList<>()).add(i);
        }

        // step-2
        for(List<Integer> list : map.values()){
            int m=list.size();
            long[] prefix=new long[m];
            prefix[0]= list.get(0);

            for(int i=1; i<m; i++){
                prefix[i]=prefix[i-1]+list.get(i);
            }

            for(int i=0; i<m; i++){
                int idx=list.get(i);

                long left=(long)i*idx-(i>0 ? prefix[i-1] : 0);
                long right=(prefix[m-1]-prefix[i])-(long)(m-i-1)*idx;

                res[idx]=left+right;
            }
        }
        return res;
    }
}