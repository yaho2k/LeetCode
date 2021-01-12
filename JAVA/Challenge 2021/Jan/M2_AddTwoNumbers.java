public class M2_AddTwoNumbers {

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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            int sum = 0;
            int carry = 0;

            sum = l1.val + l2.val;
            if (sum >= 10) {
                carry = 1;
            }

            l1 = l1.next;
            l2 = l2.next;

            ListNode HeadResult = new ListNode(sum % 10);

            ListNode res = HeadResult;
            while (l1 != null || l2 != null || carry > 0) {

                sum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + carry;
                res.next = new ListNode(sum % 10);
                if (sum >= 10) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                res = res.next;
                l1 = l1 != null ? l1.next : null;
                l2 = l2 != null ? l2.next : null;

            }

            return HeadResult;
        }
    }
}
