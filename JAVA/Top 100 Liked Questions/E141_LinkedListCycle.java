public class E141_LinkedListCycle {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public class Solution {
        public boolean hasCycle(ListNode head) {

            if (head == null || head.next == null) {
                return false;
            }

            ListNode slow = head;
            ListNode fast = head.next;

            while (fast != null) {

                fast = fast.next;
                if (fast != null) {
                    slow = slow.next;
                    fast = fast.next;
                }

                if (fast == slow) {
                    return true;
                }

            }
            return false;
        }
    }
}
