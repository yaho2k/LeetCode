public class M33_SearchinRotatedSortedArray {
    class Solution {
        public int search(int[] nums, int target) {
      
                  if (nums == null) {
                      return -1;
                  }
      
                  int index = 0;
                  while (index < nums.length - 1) {
                      if (nums[index] > nums[index + 1]) {
                          break;
                      }
                      index++;
                  }
      
                  int result = 0;
                  result = search(nums, 0, index, target);
                  if (index  < nums.length-1 && result == -1) {
                      result = search(nums, index+1, nums.length - 1, target);
                  }
                  return result;
              }
      
              private int search(int[] nums, int start, int end, int target) {
      
                  if (nums[start] > target || nums[end] < target) {
                      return -1;
                  }
                  if (start == end) {
                      if (nums[start] == target) {
                          return start;
                      } else {
                          return -1;
                      }
                  }
      
                  int result = -1;
      
                  int mid = (start + end) / 2;
      
                  result = search(nums, start, mid, target);
                  if (result == -1) {
                      result = search(nums, mid + 1, end, target);
                  }
      
                  return result;
              }
          
      }
}
