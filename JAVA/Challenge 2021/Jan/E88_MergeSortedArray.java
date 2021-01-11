public class E88_MergeSortedArray {
    class Solution {
        public void merge(int[] nums1, int m, int[] nums2, int n) {
            if (n == 0) {
                return;
            }
            int nums1S = nums1.length - 1;
            for (int i = 0; i < m; i++) {
                nums1[nums1S - i] = nums1[m - 1 - i];
            }

            int mm = nums1.length - m, nn = 0;
            for (int i = 0; i < m + n; i++) {

                if (mm >= nums1.length) {
                    nums1[i] = nums2[nn++];
                } else if (nn >= n) {
                    nums1[i] = nums1[mm++];
                } else if (nums1[mm] < nums2[nn]) {
                    nums1[i] = nums1[mm++];
                } else {
                    nums1[i] = nums2[nn++];
                }
            }
        }
    }
}
