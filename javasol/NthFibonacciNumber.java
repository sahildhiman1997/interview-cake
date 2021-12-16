package javasol;

public class NthFibonacciNumber {
    public static void main(String[] args) {
        System.out.println(findNthFibonacci(6));
    }

    private static int findNthFibonacci(int position) {
        if (position < 1) {

            throw new IllegalArgumentException("value must be in range [1,N]");
        }
        if(position==1 || position==2){
            return 1;
        }
        int i=1;
        int j = 1;

        while(position>1){
            int temp = i;
            i=j+i;
            j=temp;
            position--;
        }

        return j;
    }
}
