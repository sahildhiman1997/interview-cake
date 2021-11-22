public class MergeSortedArrays {
    public static void main(String[] args) {
        int[] myArray = new int[]{3, 4, 6, 10, 11, 15};
        int[] alicesArray = new int[]{1, 5, 8, 12, 14, 19};
        int[] sortedarr= mergeArrays(myArray, alicesArray);
        for(int i :sortedarr){
            System.out.println(i);
        }
    }

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        int[] sortedArray = new int[myArray.length + alicesArray.length];
        int a = 0, b = 0,i=0;
        while(a<myArray.length && b<alicesArray.length){
            if (myArray[a] <= alicesArray[b]) {
                sortedArray[i]=myArray[a];
                a++;
            }else{
                sortedArray[i]=alicesArray[b];
                b++;
            }
            i++;
        }
        if(a==myArray.length){
            for (int j = b; j < alicesArray.length; j++) {
                sortedArray[i]=alicesArray[j];
                i++;
            }

            }
        else{
            for (int j = a; j < myArray.length; j++) {
                sortedArray[i]=myArray[j];
                i++;
            }
        }



        return sortedArray;
    }
}