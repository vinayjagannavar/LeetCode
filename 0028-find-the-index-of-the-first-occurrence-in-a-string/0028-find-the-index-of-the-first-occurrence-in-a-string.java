class Solution {
    public int strStr(String haystack, String needle) {
        int hLength = haystack.length();
        int nLength = needle.length();

        if (nLength > hLength) {
            return -1;
        }

        for (int i = 0; i <= hLength - nLength; i++) {
            int j = 0;
            while (j < nLength && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            if (j == nLength) {
                return i; 
            }
        }

        return -1;
    }
}
