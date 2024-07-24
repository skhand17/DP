package BackTracking;

import java.util.ArrayList;
import java.util.List;

public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {

        String digits = "23";
        List<String> resultant = letterCombinations(digits);
        for(String s : resultant){
            System.out.println(s);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        if (digits == null || digits.length() == 0) {
            return combinations;
        }

        String[] mappings = {
                "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, new StringBuilder(), combinations, mappings);

        return combinations;
    }

    private static void backtrack(String digits, int index, StringBuilder current, List<String> combinations, String[] mappings) {
        if (index == digits.length()) {
            combinations.add(current.toString());
            return;
        }

        String letters = mappings[digits.charAt(index) - '0'];
        for (char letter : letters.toCharArray()) {
            current.append(letter);
            backtrack(digits, index + 1, current, combinations, mappings);
            current.deleteCharAt(current.length() - 1);
        }
    }
}
