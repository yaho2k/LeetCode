public class E234_PalindromeLinkedList {
 
  public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
 
class Solution {
    public boolean isPalindrome(ListNode head) {
          if(head ==null){
            return true;
        }

        ListNode slow = head;
        ListNode fast = head;

        while(fast!= null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid;
        
        if(fast == null){
            mid = slow;
        }else{
            mid = slow.next;
        }

        ListNode prev = null;
        ListNode next = null;

        while(mid != null){
            next = mid.next;
            mid.next = prev;
            prev = mid;
            mid = next;            
        }

        while(prev !=null){

            if(prev.val != head.val)
            return false;

            prev = prev.next;
            head = head.next;
        }

        return true; 
    }
}
}
