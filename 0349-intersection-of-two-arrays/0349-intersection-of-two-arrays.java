class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        List<Integer> ans = new ArrayList<>();
        int n = nums1.length, m = nums2.length;
        for(int i = 0; i<n; i++){
            set1.add(nums1[i]);
        }
        for(int i = 0; i<m; i++){
            if(set1.contains(nums2[i])) {
                ans.add(nums2[i]);
                set1.remove(nums2[i]);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}