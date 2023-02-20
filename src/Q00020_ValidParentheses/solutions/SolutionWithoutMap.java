package Q00020_ValidParentheses.solutions;

import java.util.Stack;

public class SolutionWithoutMap implements Solution {
    public boolean isValid(String s) {
        final Stack<Character> stack = new Stack<>();
        for (int loop = 0; loop < s.length(); loop++) {
            final char currentChar = s.charAt(loop);
            if (currentChar == '{' || currentChar == '(' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.empty()) {
                    return false;
                }

                final Character stackTop = stack.pop();
                if ((currentChar == '}' && stackTop != '{')
                        || (currentChar == ')' && stackTop != '(')
                        || (currentChar == ']' && stackTop != '[')
                ) {
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
