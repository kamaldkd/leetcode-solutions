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
    public ListNode rotateRight(ListNode head, int k) {
        if( head == null || head.next == null) return head;

        ListNode temp = head;
        int listLength = 1;
        while(temp.next != null) {
            temp = temp.next;
            listLength++;
        }
        
        int position = k % listLength;
        if (position == 0) return head;

        ListNode current = head;
        for(int i = 0; i < listLength - position - 1; i++) {
            current = current.next;
        }
        ListNode newHead = current.next;
        current.next = null;
        temp.next = head;

        return newHead;
    }
}