package javasol;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class LargestStack {
    public static void main(String[] args) {
        final MaxStack s = new MaxStack();
        s.push(5);
        System.out.println("check max after 1st add" + 5 + s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        System.out.println("check before 1st pop" + 8 + s.getMax());
        System.out.println("check pop #1" + 8 + s.pop());
        System.out.println("check max after 1st pop" + 7 + " " + s.getMax());
        System.out.println("check pop #2" + " " + 7 + " " + s.pop());
        System.out.println("check max after 2nd pop" + " " + 7 + " " + s.getMax());
        System.out.println("check pop #3" + " " + 7 + " " + s.pop());
        System.out.println("check max after 3rd pop" + " " + 5 + " " + s.getMax());
        System.out.println("check pop #4" + " " + 4 + " " + s.pop());
        System.out.println("check max after 4th pop" + " " + 5 + " " + s.getMax());
    }

    // fill in the definitions for add(), pop(), and getMax()
    public static class MaxStack {
        Stack<Integer> mystack = new Stack<Integer>();
        Stack<Integer> maxes = new Stack<Integer>();


        public void push(int item) {
            if (maxes.isEmpty()) {
                maxes.add(item);
            } else if (item >= maxes.peek()) {
                maxes.add(item);
            }
            mystack.add(item);
        }

        public int pop() {
            int item = mystack.pop();
            if (item == maxes.peek()) {
                 maxes.pop();

            }
            return item;
        }

        public int getMax() {
            if (!maxes.isEmpty()) {
                return maxes.peek();
            } else {
                return 0;
            }

        }
    }
}


