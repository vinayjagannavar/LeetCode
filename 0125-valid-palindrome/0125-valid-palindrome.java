class Solution {
    public boolean isPalindrome(String s) {
        String cleanedStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        
        int i = 0;
        int j = cleanedStr.length() - 1;

        while (i < j) {
            if (cleanedStr.charAt(i) != cleanedStr.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }

        return true;
    }
}