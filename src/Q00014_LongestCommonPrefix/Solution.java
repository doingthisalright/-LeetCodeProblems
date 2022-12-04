package Q00014_LongestCommonPrefix;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        for (int maxIndex = 0; maxIndex < strs[0].length() ; maxIndex++){
            char currentChar = strs[0].charAt(maxIndex);
            for (int strsItr = 1; strsItr < strs.length; strsItr++) {
                if (maxIndex == strs[strsItr].length()
                        || strs[strsItr].charAt(maxIndex) != currentChar
                ) {
                    return strs[0].substring(0, maxIndex);
                }

            }
        }

        return strs[0];
    }
}