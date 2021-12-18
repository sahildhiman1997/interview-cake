package javasol;

public class MatchingParenthesis {
    public static void main(String[] args) {

    }

    public static int getClosingParen(String sentence, int openingParenIndex) {
        int count = 1;
        // find the position of the matching closing parenthesis
        for (int i = openingParenIndex; i < sentence.length(); i++) {
            if (sentence.charAt(i) == '(') {
                count++;
            } else if (sentence.charAt(i) == ')') {
                count--;
            }
            if (count == 0) {
                return i;
            }
        }

        return 0;
    }

}
