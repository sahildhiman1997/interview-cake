import java.util.HashSet;

public class PermutationPalindrome {
    public static void main(String[] args) {

    }
    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
//        simple, there can be max one character, that appears odd times, all other characters must appear even times only
        HashSet set = new HashSet();
        for(char c: theString.toCharArray()){
            if(set.contains(c)){
                set.remove(c);
            }else{
                set.add(c);
            }
        }
        if(set.size()<2){
            return  true;
        }


        return false;
    }
}
