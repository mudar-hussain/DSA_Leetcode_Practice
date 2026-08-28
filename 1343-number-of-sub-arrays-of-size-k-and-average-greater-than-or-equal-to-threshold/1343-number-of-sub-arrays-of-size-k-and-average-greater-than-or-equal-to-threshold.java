class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int left = 0;
        int right = 0;
        int count = 0;
        int size = 0;
        int sum = 0;
        while(right<arr.length) {
            sum = sum + arr[right++];
            size++;
            if(size == k) {
                if(sum >= k*threshold) {
                    count++;
                }
                sum -= arr[left++];
                size--;
            }
        }
        return count;
        
    }
}