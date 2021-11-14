import java.util.HashSet;

public class InflightEntertainment {
    public static void main(String[] args) {
        int flightLength=10;
        int[] movies ={3,4,1,0,5,0,4};
        System.out.println(canTwoMoviesFillFlight(movies, flightLength));
    }
    public static boolean canTwoMoviesFillFlight(int[] movieLengths, int flightLength) {

        HashSet set = new HashSet();
        for(int movieLength : movieLengths){
            if(set.contains(flightLength-movieLength)){
                return  true;
            }else{
                set.add(movieLength);
            }
        }


        return false;
    }
}
