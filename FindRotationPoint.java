public class FindRotationPoint {
    public static void main(String[] args) {
        System.out.println("dahil".compareTo("dhiman"));
        String[] words = new String[]{

                "asymptote",  // <-- rotates here!
                "babka",
                "banoffee",
                "engender",
                "karpatka",
                "othellolagkage",
        };
        System.out.println(findRotationPoint(words));
    }
    public static int findRotationPoint(String[] words) {

        // find the rotation point in the array
        int floor = 0;
        int ceil = words.length - 1;
        int position = (ceil - floor) / 2 + floor;
        while (ceil - floor > 1) {
            if (words[floor].compareTo(words[position]) > 0) {
                ceil = position;
//                floor+=1;
            } else {
                floor = position;
//                ceil-=1;
            }
            position = ((ceil - floor) / 2) + floor;
        }

        return ceil;
    }
}
