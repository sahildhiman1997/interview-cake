public class FindDuplicate {
    public static void main(String[] args) {
        int[] x = {1,3,2,3,3};
        System.out.println(findRepeat(x));

    }

    public static int findRepeat(int[] numbers) {

        int floor = 0;
        int ceil = numbers.length - 1;
        int middle = (floor+ceil)/2;
        while (ceil !=middle || middle!=ceil) {
            int lesser = 0;

            for (int i : numbers) {
                if (i <= middle) {
                    lesser++;
                }
            }
            if (lesser <= middle) {
                floor = middle + 1;
            } else {
                ceil = middle;

            }
            middle = (floor+ceil)/2;
        }

        return middle;
    }


}
