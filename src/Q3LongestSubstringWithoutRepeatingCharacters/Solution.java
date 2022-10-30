package Q3LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int currentStartIndex = 0;
        final Map<Character, Integer> lastCharOccurrence = new HashMap<>();

        for (int currentEndIndex = 0; currentEndIndex < s.length(); currentEndIndex++) {
            final Character currentChar = s.charAt(currentEndIndex);
            if (lastCharOccurrence.containsKey(currentChar)) {
                final int lastOccurrence = lastCharOccurrence.get(currentChar);
                for (int loop = currentStartIndex; loop <= lastOccurrence; loop++) {
                    lastCharOccurrence.remove(s.charAt(loop));
                }
                currentStartIndex = lastOccurrence + 1;
            } else {
                maxLength = Math.max(maxLength, currentEndIndex - currentStartIndex + 1);
            }
            lastCharOccurrence.put(currentChar, currentEndIndex);
        }

        return maxLength;
    }
}