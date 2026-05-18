class Solution {
    private boolean isValid(int[] arr, int k, int d) {
        int low = 0, high = arr.length-1;
        while(low<=high) {
            int mid = low + (high-low)/2;
            if(Math.abs(arr[mid]-k) <= d) return false;
            else if (arr[mid]-k > d) high = mid-1;
            else low = mid+1;
        }
        return true;
    }
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        Arrays.sort(arr2);
        int res = 0;
        for(int num: arr1) {
            if(isValid(arr2, num, d)) res++;
        }
        return res;
    }
}