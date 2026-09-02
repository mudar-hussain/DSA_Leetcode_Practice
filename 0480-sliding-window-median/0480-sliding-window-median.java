class Solution {
    private void removeElement(TreeSet<Integer> minSet, TreeSet<Integer> maxSet, int[] nums, int idx) {
        if(maxSet.contains(idx)) {
            maxSet.remove(idx);
            if(minSet.size() == maxSet.size()+2) {
                maxSet.add(minSet.pollFirst());
            }
        } else {
            minSet.remove(idx);
            if(minSet.size()<maxSet.size()) {
                minSet.add(maxSet.pollFirst());
            }
        }
    }
    private void addElement(TreeSet<Integer> minSet, TreeSet<Integer> maxSet, int idx) {
        minSet.add(idx);
        maxSet.add(minSet.pollFirst());
        if(minSet.size()<maxSet.size()) {
            minSet.add(maxSet.pollFirst());
        }
    }
    private double getMedian(TreeSet<Integer> minSet, TreeSet<Integer> maxSet, int[] nums) {
        if(minSet.size() == maxSet.size()) {
            return ((double) nums[minSet.first()] + (double) nums[maxSet.first()])/2.0;
        }
        return (double) nums[minSet.first()];
    }
    public double[] medianSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        double[] res = new double[n-k+1];
        TreeSet<Integer> minSet = new TreeSet<>((a,b) -> nums[a] != nums[b] ? Integer.compare(nums[a], nums[b]) : a-b);
        TreeSet<Integer> maxSet = new TreeSet<>((a,b) -> nums[a] != nums[b] ?Integer.compare(nums[b], nums[a]) : b-a);
        for(int i = 0; i<n; i++) {
            if(i>=k) {
                removeElement(minSet, maxSet, nums, i-k);
            }
            addElement(minSet, maxSet, i);
            if(i>=k-1) {
                res[i-k+1] = getMedian(minSet, maxSet, nums);
            }
        }
        return res;
    }
}