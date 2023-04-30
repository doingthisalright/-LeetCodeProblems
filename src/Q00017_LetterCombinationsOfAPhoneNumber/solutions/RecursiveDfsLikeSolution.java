package Q00017_LetterCombinationsOfAPhoneNumber.solutions;

import java.util.ArrayList;
import java.util.List;

public class RecursiveDfsLikeSolution implements Solution {
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

        final List<String> combos = new ArrayList<>();
        append(digitToChar, combos, digits.toCharArray(), 0, new StringBuilder());
        return combos;
    }

    private void append(
            final char[][] digitToChar,
            final List<String> combos,
            final char[] digits,
            final int currentDigitPosition,
            final StringBuilder currentString
    ) {
        if (currentDigitPosition == digits.length) {
            combos.add(currentString.toString());
            return;
        }

        final char[] charsForDigit = digitToChar[Character.getNumericValue(digits[currentDigitPosition])];
        for (final char digitChar: charsForDigit) {
            append(digitToChar, combos, digits, currentDigitPosition + 1, currentString.append(digitChar));
            currentString.deleteCharAt(currentString.length() - 1);
        }
    }

    public String solutionDescription() {
        return "Recursive DFS-like Solution";
    }
}
