package Q00020_ValidParentheses.solutions;

import java.util.Map;
import java.util.Stack;

public class SolutionWithMap implements Solution {
    private static final Map<Character, Character> BRACKET_MAP = Map.of(
            ')', '(',
            '}', '{',
            ']', '['
    );
    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (int loop = 0; loop < s.length(); loop++) {
            final Character currentChar = s.charAt(loop);
            if (BRACKET_MAP.containsValue(currentChar)) {
                stack.push(currentChar);
            } else {
                if (stack.empty()) {
                    return false;
                }

                final Character stackTop = stack.pop();
                if (BRACKET_MAP.get(currentChar) != stackTop) {
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public String solutionDescription() {
        return "Solution without using Maps";
    }
}
