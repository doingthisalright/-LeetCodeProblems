package Q00009_PalindromeNumber;

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int xBackup = x;
        int xReverse = 0;

        while (x != 0) {
            xReverse = xReverse * 10 + x % 10;
            x = x/10;
        }

        return xBackup == xReverse;
    }

    public boolean isPalindromeStringBased(int x) {
        final StringBuilder originalNumberBuilder = new StringBuilder(Integer.toString(x));
        final String originalNumberAsString = originalNumberBuilder.toString();
        final String reverseNumberAsString = originalNumberBuilder.reverse().toString();

        return originalNumberAsString.equals(reverseNumberAsString);
    }
}