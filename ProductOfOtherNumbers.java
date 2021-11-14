import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

public class ProductOfOtherNumbers {
    public static void main(String[] args) {

            System.out.println(Arrays.toString(getProductsOfAllIntsExceptAtIndex(new int[]   {84, 12, 28, 21})));
        }

    public static int[] getProductsOfAllIntsExceptAtIndex(int[] intArray) {

        // make an array of the products
        if(intArray.length<2){
            throw new IllegalArgumentException("Not allowed");
        }

        int[] answer = new int[intArray.length];
        answer[0]=1;
        for (int i = 1; i < answer.length; i++) {
            answer[i]=intArray[i-1]*answer[i-1];
        }
        int productFromLast = intArray[intArray.length-1];
        for (int i = answer.length-2; i >-1 ; i--) {
            answer[i]=productFromLast*answer[i];
            productFromLast*=intArray[i];
        }
        return answer;
    }
}
