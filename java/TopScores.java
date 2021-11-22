import java.util.Arrays;

public class TopScores {
    public static void main(String[] args) {
        int[] unsortedScores = {37, 89, 41, 65, 91, 53};
        System.out.println(Arrays.toString(sortScores(unsortedScores, 100)));
    }
    public static int[] sortScores(int[] unorderedScores, int highestPossibleScore) {

        // sort the scores in O(n) time
        int[] scoreData = new int[highestPossibleScore];
        
        for (int score : unorderedScores){
            scoreData[score]+=1;
        }


        int[] answer = new int[unorderedScores.length];

        int pointer = 0;
        for (int i = scoreData.length-1; i >-1; i--) {
            int numberOfPlayers = scoreData[i];
            for (int j = 0; j < numberOfPlayers; j++) {
                answer[pointer]=i;
                pointer++;
            }
        }
        

        return answer;
    }

}

