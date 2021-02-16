public class M11_ContainerWithMostWater {

    static class Solution {
        public int maxArea(int[] height) {
            int result = 0;
            int tmp = 0;
            int start = 0, end = height.length - 1;
            while (start < end) {
                tmp = Math.min(height[start], height[end]) * (end - start);
                if (tmp > result) {
                    result = tmp;
                }
                if (height[start] < height[end]) {
                    start++;
                } else {
                    end--;
                }
            }
            return result;
        }

        public int maxArea2(int[] height) {
            int result = 0;
            int tmp = 0;
            for (int i = 0; i < height.length - 1; i++) {
                for (int j = height.length - 1; j > i; j--) {
                    tmp = Math.min(height[i], height[j]) * (j - i);
                    if (tmp > result) {
                        result = tmp;
                    }
                }
            }
            return result;
        }
    }
}
