import java.util.Arrays;

public class CafeOrderChecker {
    public static void main(String[] args) {
        int[] outOrders = {1, 9};
        int[] dineInorders = {7, 8};
        int[] served =  {1, 7, 8};
        System.out.println(isFirstComeFirstServed(outOrders, dineInorders, served));
    }

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {
        if(takeOutOrders.length+dineInOrders.length!=servedOrders.length) return  false;
        if (takeOutOrders.length == 0 ) {
            if(false == Arrays.equals(dineInOrders, servedOrders)){

                return false;
            }
        }
        else if(dineInOrders.length == 0){
            if(false == Arrays.equals(servedOrders, servedOrders)){
                return  false;
            }
        }

        else {
            int a = 0,b=0;
            for (int i : servedOrders) {
                if (takeOutOrders[a] == i) {
                    if (a < takeOutOrders.length - 1)
                        a++;
                } else if (dineInOrders[b] == i) {
                    if (b < dineInOrders.length - 1)
                        b++;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
