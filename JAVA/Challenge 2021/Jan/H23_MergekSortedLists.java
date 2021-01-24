public class H23_MergekSortedLists {

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

/*     
Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output: [1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
  1->4->5,
  1->3->4,
  2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists = []
Output: []

Example 3:
Input: lists = [[]]
Output: [] 
*/

    class Solution {
        public ListNode mergeKLists(ListNode[] lists) {

            if(lists == null || lists.length == 0){
                return null;
            }
            
            ListNode result = new ListNode();
            ListNode node = result;
            int min = Integer.MAX_VALUE;
            int minIndex = -1;

            while(true){
                for(int i = 0; i< lists.length ; i++){
                    if(lists[i] != null && min > lists[i].val){
                        min = lists[i].val;
                        minIndex = i;
                    }
                }
                if(minIndex == -1){
                    return result.next;
                }
                node.next = new ListNode(lists[minIndex].val);
                node = node.next;
                lists[minIndex] = lists[minIndex].next;
                min = Integer.MAX_VALUE;
                minIndex = -1;

                boolean found = false;
                for(int i = 0; i< lists.length ; i++){
                    if(lists[i] != null){
                        found = true;
                    }
                }

                if(!found){
                    return result.next;
                }
            }
        }
    }
}
