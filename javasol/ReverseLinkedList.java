package javasol;

public class ReverseLinkedList {
    public static void main(String[] args) {

    }

    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }


    public static LinkedListNode reverse(LinkedListNode headOfList) {

        // reverse the linked list in place

        if(headOfList==null){
            return null;
        }

        LinkedListNode current = headOfList;
        LinkedListNode temp = current.next;
        headOfList.next=null;
        LinkedListNode previous = current;

        while(temp!=null) {

            current = temp;
            temp = current.next;
            current.next=previous;
            previous = current;

        }

        return current;
    }




}
