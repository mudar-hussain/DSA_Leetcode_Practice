class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int[] exist = new int[1001];
        List<Integer> ans = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        for(int i = 0; i<n; i++) {
            exist[nums1[i]] = 1;
        }
        for(int i = 0; i<m; i++){
            if(exist[nums2[i]]==1) {
                ans.add(nums2[i]);
                exist[nums2[i]]=0;
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}