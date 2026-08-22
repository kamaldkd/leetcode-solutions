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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // We will use sizes to understand which list's nodes should be frozen for a while.
        int s1 = size(l1);
        int s2 = size(l2);
        ListNode resHead = null;
        ListNode curr = null;
        while (l1 != null || l2 != null) {
            int value1 = 0;
            int value2 = 0;
            if (s1 >= s2) {
                value1 = l1 != null ? l1.val : 0;
                l1 = l1.next;
                s1--;
            }
            // Comparing with s1 + 1 since s1 might be decremented previously
            if (s2 >= s1 + 1) {
                value2 = l2 != null ? l2.val : 0;
                l2 = l2.next;
                s2--;
            }
            // Creating the resulting list in the reversed order.
            curr = new ListNode(value1 + value2);
            curr.next = resHead;
            resHead = curr;
        }

        ListNode prev = null;

        int carry = 0;
        prev = null;
        while (curr != null) {
            curr.val += carry;
            if (curr.val >= 10) {
                curr.val = curr.val % 10;
                carry = 1;
            } else {
                carry = 0;
            }

            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        if (carry > 0) {
            curr = new ListNode(carry);
            curr.next = prev;
            prev = curr;
        }

        return prev;
    }

    private int size(ListNode l) {
        int s = 0;
        while (l != null) {
            l = l.next;
            s++;
        }
        return s;
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna