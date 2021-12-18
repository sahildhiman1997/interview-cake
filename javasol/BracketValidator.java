package javasol;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class BracketValidator {
    public static void main(String[] args) {
        System.out.println(isValid("[[]]())"));
    }

    public static boolean isValid(String code) {
        Map<Character, Character> bracketsMatcher = new HashMap<Character, Character>();
        bracketsMatcher.put('{', '}');
        bracketsMatcher.put('[', ']');

        bracketsMatcher.put('(', ')');
        Stack<Character> openingBrackets = new Stack<>();
        // determine if the input code is valid
        for (int i = 0; i < code.length(); i++) {
            if (bracketsMatcher.containsKey(code.charAt(i))) {
                openingBrackets.push(code.charAt(i));
            } else {
                if (bracketsMatcher.containsValue(code.charAt(i))) {
                    if(!openingBrackets.isEmpty()){
                        Character cc = openingBrackets.pop();

                    if(bracketsMatcher.get(cc)!=code.charAt(i)){
//                        System.out.println("code at "+code.charAt(i)+i +" was not liked");
                        return false;
                    }}else{
                        return false;
                    }
                }
            }
        }
      if(openingBrackets.isEmpty()){
          return true;
      }return false;
    }


}
