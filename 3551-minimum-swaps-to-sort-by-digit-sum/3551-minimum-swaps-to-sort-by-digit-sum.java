class Solution {
    private static int digitSum(int a) {
        int sum = 0;
        while(a>0){
            sum += a%10;
            a = a/10;
        }
        return sum;
    }
    public int minSwaps(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i<nums.length; i++){
            map.put(nums[i], i);
        }
        Integer[] arr = new Integer[nums.length];
        for(int i = 0; i<nums.length; i++) {
            arr[i] = nums[i];
        }
        Arrays.sort(arr, (a,b) -> {
            int sumA = digitSum(a);
            int sumB = digitSum(b);
            return sumA==sumB ? a-b : sumA-sumB;
        });
        int count = 0;
        int i = 0;
        while(i<arr.length) {
            int j = map.get(arr[i]);
            if(i!=j) {
                count++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            } else {
                i++;
            }
        }
        return count;
    }
}