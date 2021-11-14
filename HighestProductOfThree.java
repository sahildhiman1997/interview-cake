public class HighestProductOfThree {
    public static void main(String[] args) {
        int[] k = {2, 5};
        for (int i = 3; i < k.length; i++) {
            System.out.println("Hey ...");
        }
        System.out.println(highestProductOf3(new int[]{-5, -1, -3, -2}));
    }

    public static int highestProductOf3(int[] intArray) {
        int largestProductOfTwo = intArray[0] * intArray[1];
        int smallestProductOfTwo = intArray[0] * intArray[1];
        int smallest = Math.min(intArray[0], intArray[1]);
        int largest = Math.max(intArray[0], intArray[1]);
        int answer = intArray[0] * intArray[1] * intArray[2];
        for (int i = 2; i < intArray.length; i++) {
            int current = intArray[i];
            answer = Math.max(answer, Math.max(current * largestProductOfTwo, current * smallestProductOfTwo));

            smallestProductOfTwo = Math.min(smallestProductOfTwo, Math.min(current * largest,smallest * current));
            smallest = Math.min(current, smallest);

            largestProductOfTwo = Math.max(Math.max(current * largest,smallest * current),largestProductOfTwo );
            largest = Math.max(largest, current);
        }
        return answer;
    }
}
