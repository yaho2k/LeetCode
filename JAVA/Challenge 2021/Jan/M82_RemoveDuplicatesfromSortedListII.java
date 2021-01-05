public class M82_RemoveDuplicatesfromSortedListII {

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
     * Example 1: Input: head = [1,2,3,3,4,4,5] Output: [1,2,5]
     * 
     * Example 2: Input: head = [1,1,1,2,3] Output: [2,3]
     * 
     * Input: [1,1,2,2] Output: [2] Expected: []
     */

    class Solution {
        public ListNode deleteDuplicates(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }

            ListNode node = head;
            ListNode prev = null;

            while (node != null && node.next != null) {
                if (node.val == node.next.val) {
                    node.next = delete(node);
                    if (prev == null) {
                        prev = node.next;
                    } else {
                        prev.next = node.next;
                    }
                    if (head.val == node.val) {
                        head = node.next;
                    }
                    node = node.next;
                } else {
                    prev = node;
                    node = node.next;
                }
            }

            return head;

        }

        ListNode delete(ListNode node) {

            while (node.next != null) {
                if (node.val == node.next.val) {
                    node.next = node.next.next;
                } else {
                    return node.next;
                }
            }

            return node.next;
        }
    }
}
