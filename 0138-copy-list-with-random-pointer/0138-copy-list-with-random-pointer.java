/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public void insertCopyInBetween(Node head) {
        Node temp = head;
        while(temp != null) {
            Node newNode = new Node(temp.val);
            newNode.next = temp.next;
            temp.next = newNode;
            temp = temp.next.next;
        }
    }
    public void connectRandomPointers(Node head) {
        Node temp = head;
        while(temp!= null) {
            Node copyNode = temp.next;
            if(temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }
    public Node getDeepCopyList(Node head) {
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        Node temp = head;
        while(temp != null) {
            res.next = temp.next;
            res = res.next;

            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }
    public Node copyRandomList(Node head) {
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }
}