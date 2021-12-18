package javasol;

public class KthToLastNode {
    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static LinkedListNode kthToLastNode(int k, LinkedListNode head) {
        if (k == 0) throw new IllegalArgumentException("0 not allowed");
        if (head == null) throw new NullPointerException("head cannot be null");

        LinkedListNode temp2 = null;
        LinkedListNode temp1 = null;
        if (k == 1) {
            while (head.next != null) {
                head = head.next;
            }
            return head;
        }

        LinkedListNode current = head;
        int count = 1;
        while (current != null) {
            if (count == k) {
                count = 0;
                temp1 = temp2;
                temp2 = current;
            }
            current = current.next;
            count++;
        }
        if (temp2 == null) {
            throw new IllegalArgumentException("k is smaller than length");

        } else {
            current = temp1;
            for (int i = 0; i < count; i++) {
                current = current.next;
            }
        }


        return current;
    }
}
