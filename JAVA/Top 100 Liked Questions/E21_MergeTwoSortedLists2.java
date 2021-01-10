public class E21_MergeTwoSortedLists2 {

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

    class Solution {
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }

            ListNode resultHead;
            ListNode preceed;
            if (l1.val <= l2.val) {
                resultHead = l1;
                l1 = l1.next;
            } else {
                resultHead = l2;
                l2 = l2.next;
            }
            preceed = resultHead;

            while (l1 != null || l2 != null) {

                if (l1 == null && l2 != null) {
                    preceed.next = l2;
                    l2 = l2.next;
                } else if (l2 == null && l1 != null) {
                    preceed.next = l1;
                    l1 = l1.next;
                } else if (l1.val <= l2.val) {
                    preceed.next = l1;
                    l1 = l1.next;
                } else {
                    preceed.next = l2;
                    l2 = l2.next;
                }

                preceed = preceed.next;

            }

            return resultHead;
        }
    }
}
