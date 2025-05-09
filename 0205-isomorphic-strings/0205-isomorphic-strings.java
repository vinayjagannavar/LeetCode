class Solution {
    public boolean isIsomorphic(String s, String t) {
        // Create arrays to store the index of characters in both strings
        int[] indexS = new int[256]; // Stores index of characters in string s
        int[] indexT = new int[256]; // Stores index of characters in string t
        
        // Get the length of both string
        
        // If the lengths of the two strings are different, they can't be isomorphic
        if(s.length() != t.length()) {
            return false;
        }
        
        // Iterate through each character of the strings
        for(int i = 0; i < s.length(); i++) {
            // Check if the index of the current character in string s
            // is different from the index of the corresponding character in string t
            if(indexS[s.charAt(i)] != indexT[t.charAt(i)]) {
                return false; // If different, strings are not isomorphic
            }
            
            // Update the indices of characters in both strings
            indexS[s.charAt(i)] = i + 1; // updating index of current character
            indexT[t.charAt(i)] = i + 1; // updating index of current character
        }
        
        // If the loop completes without returning false, strings are isomorphic
        return true;
    }
}
