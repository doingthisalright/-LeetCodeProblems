package Q9PalindromeNumber;

public class Q9PalindromeNumber {
    public static void main(String[] args) {
        final Integer input = 121;
        final boolean expectedAnswer = true;
        final boolean result = new Solution().isPalindrome(input);

        if (result == expectedAnswer) {
            System.out.println("Correct answer!");
        } else {
            System.out.format("Wrong answer. Expected %s. Your answer %s", expectedAnswer, result);
        }
    }
}