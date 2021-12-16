package javasol;

import java.lang.reflect.Array;
import java.util.Arrays;

public class MakingChange {
    public static void main(String[] args) {
        System.out.println(changePossibilities(4, new int[] {1, 2, 3}));
    }

    public static int changePossibilities(int amount, int[] denominations) {

        // calculate the number of ways to make change
        if (amount == 0) {
            return 1;
        }
        if (denominations.length == 0) return 0;

        denominations = Arrays.stream(denominations).sorted().toArray();
        if (amount < denominations[0]) {
            return 0;
        }

        int[][] possibilities = new int[denominations.length][amount+1];


        for (int i = 0; i < amount+1; i++) {
            if(i%denominations[0]==0) possibilities[0][i]=1; else possibilities[0][i]=0;
        }

        for (int i = 1; i < denominations.length; i++) {
            possibilities[i][0]=1;
            for (int j = 1; j < denominations[i]; j++) {
                possibilities[i][j]=possibilities[i-1][j];
            }
            for (int j =denominations[i]; j < amount+1; j++) {
                int val = possibilities[i-1][j]+possibilities[i][j-denominations[i]];
//                System.out.println("Setting val "+possibilities[i-1][j]+"+"+possibilities[i][j-i]+" ="+val+" at "+i+", "+j);
               possibilities[i][j]=val;
            }
        }
//        for (int i = 0; i < possibilities.length; i++) {
//            System.out.println(Arrays.toString(possibilities[i]));
//        }
        return possibilities[denominations.length-1][amount];
    }
}
