package javasol;

public class DeleteNode {
    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static void deleteNode(LinkedListNode nodeToDelete) {
        if( nodeToDelete.next == null){
            throw new NullPointerException("dd");
        }
        // delete the input node from the linked list
        LinkedListNode nextnode =  nodeToDelete.next;
        while (nextnode != null) {
            nodeToDelete.value=nodeToDelete.next.value;
            nodeToDelete.next=nodeToDelete.next.next;
            nodeToDelete=nodeToDelete.next;
        }

    }

}
