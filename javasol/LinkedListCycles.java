package javasol;

public class LinkedListCycles {
public  static class User{
    String name;}

    public static void main(String[] args) {
        User u = null;
        System.out.println(u==null && u.name!=null);
    }
    public static class LinkedListNode {

        public int value;
        public LinkedListNode next;

        public LinkedListNode(int value) {
            this.value = value;
        }
    }

    public static boolean containsCycle(LinkedListNode firstNode) {

        // check if the linked list contains a cycle
        LinkedListNode turtle = firstNode;
        LinkedListNode rabbit = firstNode;
        while(rabbit!=null && rabbit.next!=null){
            if(turtle==rabbit){
                return true;
            }
            turtle=turtle.next;
            rabbit=rabbit.next.next;
        }
        return false;
    }

}
