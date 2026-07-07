/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
      // creating a dummy node 
      ListNode dummy = new ListNode(0);
    
      // point dummy's next to head
         dummy.next = head;

      ListNode prev = dummy;

      while (prev.next != null && prev.next.next != null) {
          
          //Identify nodes to swap
          ListNode first = prev.next;
          ListNode second = prev.next.next;

          //swap these nodes
          first.next = second.next;
          second.next = first;

          //prepare for next
          prev.next = second;
           prev = first;
      }
       
       //return the head
        return dummy.next;
        
    }
}