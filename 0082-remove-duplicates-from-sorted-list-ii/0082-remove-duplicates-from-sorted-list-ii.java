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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;

        ListNode dummy = new ListNode(-101);
        dummy.next = head;
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode preSlow = dummy;

        while (fast != null) {
            if (slow.val != fast.val) {
                preSlow = slow;
                slow = slow.next;
                fast = fast.next;
            } else if(slow.val == fast.val) {
                while(fast != null && slow.val == fast.val) {
                    fast = fast.next;
                }
                slow = fast;
                if(fast != null) fast = fast.next;
                preSlow.next = slow;
            }  
        }
        return dummy.next;
    }
}