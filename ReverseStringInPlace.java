import java.awt.*;
import java.util.Deque;
import java.util.Queue;
import java.util.concurrent.SynchronousQueue;

public class ReverseStringInPlace {
    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c'};
        Queue k = new SynchronousQueue() ;
        k.add(4);
        k.add(1);
        k.peek();
        k.poll();


    }

    public static void reverse(char[] arr) {
        if (arr.length > 1) {
            for (int i = 0; i <= arr.length / 2; i++) {
                char temp = arr[i];
                arr[i] = arr[arr.length - i - 1];
                arr[arr.length - i - 1] = temp;
            }
        }
    }
}
