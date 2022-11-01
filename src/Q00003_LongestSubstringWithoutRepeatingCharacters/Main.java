package Q00003_LongestSubstringWithoutRepeatingCharacters;

public class Main {
    public static void main(String[] args) {
        final String inputString = "abcabcbb";
        final int expectedLength = 3;
        final int result = new Solution().lengthOfLongestSubstring(inputString);

        if (result == expectedLength) {
            System.out.println("Correct answer!");
        } else {
            System.out.format("Wrong answer. Expected %s. Your answer %s", expectedLength, result);
        }
    }
}
