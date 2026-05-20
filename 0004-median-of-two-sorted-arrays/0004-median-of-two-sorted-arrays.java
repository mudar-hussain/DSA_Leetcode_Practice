class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        // Always binary search smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int x = nums1.length;
        int y = nums2.length;

        int low = 0;
        int high = x;

        while (low <= high) {

            int partitionX = low + (high - low) / 2;

            int partitionY = (x + y + 1) / 2 - partitionX;

            int maxLeftX =
                (partitionX == 0)
                ? Integer.MIN_VALUE
                : nums1[partitionX - 1];

            int minRightX =
                (partitionX == x)
                ? Integer.MAX_VALUE
                : nums1[partitionX];

            int maxLeftY =
                (partitionY == 0)
                ? Integer.MIN_VALUE
                : nums2[partitionY - 1];

            int minRightY =
                (partitionY == y)
                ? Integer.MAX_VALUE
                : nums2[partitionY];

            if (maxLeftX <= minRightY &&
                maxLeftY <= minRightX) {

                // Even total length
                if ((x + y) % 2 == 0) {

                    return (
                        Math.max(maxLeftX, maxLeftY)
                        +
                        Math.min(minRightX, minRightY)
                    ) / 2.0;
                }

                // Odd total length
                return Math.max(maxLeftX, maxLeftY);
            }

            else if (maxLeftX > minRightY) {
                high = partitionX - 1;
            }

            else {
                low = partitionX + 1;
            }
        }

        return 0.0;
    }
}