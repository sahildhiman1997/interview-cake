public class ReverseWords {
    public static void main(String[] args) {

        char[] message = {'c', 'a', 'k', 'e', ' ',
                'p', 'o', 'u', 'n', 'd', ' ',
                's', 't', 'e', 'a', 'l'};
        reverseWords(message);
    }
    public static void reverseWords(char[] message) {
        // first we reverse the whole array : O(n)
//        this will result in all array reversed, all words will be backwards.
        for (int i = 0; i < message.length / 2; i++) {
            char temp = message[i];
            message[i] = message[message.length - i - 1];
            message[message.length - i - 1] = temp;
        }

//        make the words spell forward O(n) again.
        int start = 0;
        for (int i = 0; i < message.length; i++) {

            if (message[i] == ' ') {
                reverseSingleWord(message, start, i);
                start=i+1;
            }

        }
        reverseSingleWord(message, start, message.length);
System.out.println(message);
    }

    private static void reverseSingleWord(char[] message, int start, int end) {
        for (int i = start; i < (end + start) / 2; i++) {
            char temp = message[i];
            message[i] = message[end - (i-start)-1];
            message[end - (i-start)-1] = temp;
        }
    }
}
