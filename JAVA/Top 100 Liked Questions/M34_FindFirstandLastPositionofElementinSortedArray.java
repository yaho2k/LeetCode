public class M34_FindFirstandLastPositionofElementinSortedArray {
    class Solution {
        public int[] searchRange(int[] nums, int target) {
               int[] result = { -1, -1 };
               if (nums == null || nums.length == 0) {
                   return result;
               }
   
               result = searchRange(nums, 0, nums.length - 1, nums.length - 1, target);
   
               return result;
           }
   
           private int[] searchRange(int[] nums, int start, int end, int total, int target) {
               int[] result = { -1, -1 };
               if (start == end) {
                   if (nums[start] == target) {
                       return searchAnswer(nums,start, end, start , target);
                   } else {
                       return result;
                   }
   
               }
   
               int mid = start + (end - start) / 2;
   
               if (target > nums[mid]) {
                   result = searchRange(nums, mid + 1, end, total, target);
               } else if (target < nums[mid]) {
                   result = searchRange(nums, start, mid, total, target);
               } else {
                   return searchAnswer(nums,start, end, mid , target);
               }
   
               return result;
           }
   
           private int[] searchAnswer(int[] nums, int start, int end, int mid, int target) {
               int[] result = { -1, -1 };
               result[0]=mid;
               result[1]=mid;
        
               int t1 = mid;
               while(t1 >start && nums[t1]==nums[t1-1]){
                   t1--;
                   result[0]=t1;
               }
        
               int t2 = mid;
               while(t2 < end&& nums[t2]==nums[t2+1]){
                   t2++;
                   result[1]=t2;
               }
                  return result;
              }
       
       
   }
}
