package Q00017_LetterCombinationsOfAPhoneNumber.solutions;

import java.util.ArrayList;
import java.util.List;

public class IterativeBfsLikeSolution implements Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }

        final char[][] digitToChar = {
                {},
                {},
                {'a','b','c'},
                {'d','e','f'},
                {'g','h','i'},
                {'j','k','l'},
                {'m','n','o'},
                {'p','q','r','s'},
                {'t','u','v'},
                {'w','x','y','z'}
        };

        List<String> combos = new ArrayList<>();

        combos.add("");
        for (char digit: digits.toCharArray()) {
            final char[] charsForDigit = digitToChar[Character.getNumericValue(digit)];

            final List<String> newCombos = new ArrayList<>();
            combos.forEach(currentCombo -> {
                for (final char digitChar: charsForDigit) {
                    newCombos.add(currentCombo + digitChar);
                }
            });
            combos = newCombos;
        }

        return combos;
    }

    public String solutionDescription() {
        return "Iterative BFS-like Solution";
    }
}
