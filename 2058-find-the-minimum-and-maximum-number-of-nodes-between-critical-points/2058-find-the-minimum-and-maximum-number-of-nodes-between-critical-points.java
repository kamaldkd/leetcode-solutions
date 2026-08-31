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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> criticals = new ArrayList<>();

        if(head.next == null) return new int[]{-1, -1};

        ListNode prev = head;
        ListNode curr = head.next;

        int index = 1;
        while(curr.next != null) {
            index++;

            if((prev.val < curr.val && curr.next.val < curr.val) || 
                (prev.val > curr.val && curr.next.val > curr.val)) {
                    criticals.add(index);
            }

            prev = curr;
            curr = curr.next;
        }

        if(criticals.size() >= 2) {
            int[] dist = new int[2];

            dist[1] = criticals.get(criticals.size() - 1) - criticals.get(0);

            dist[0] = Integer.MAX_VALUE;
            for(int i = 1; i < criticals.size(); i++) {
                int min = criticals.get(i) - criticals.get(i - 1);

                dist[0] = Math.min(dist[0], min);
            }

            return dist;
        }
        return new int[]{-1, -1};
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna