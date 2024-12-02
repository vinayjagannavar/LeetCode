class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        int wordIndex = 0; // Tracks the word's position
        int i = 0;         // Index for sentence traversal

        while (i < sentence.length()) {
            wordIndex++; // Start of a new word
            int j = 0;   // Index for searchWord
            boolean isPrefix = true;

            // Check if searchWord matches the current word
            while (i < sentence.length() && sentence.charAt(i) != ' ') {
                if (j < searchWord.length() && sentence.charAt(i) == searchWord.charAt(j)) {
                    j++;
                } else if (j < searchWord.length()) {
                    isPrefix = false; // Not a prefix
                }
                i++;
            }

            // If all characters of searchWord are matched, return the word index
            if (isPrefix && j == searchWord.length()) {
                return wordIndex;
            }

            // Skip the space between words
            while (i < sentence.length() && sentence.charAt(i) == ' ') {
                i++;
            }
        }

        // If no match is found, return -1
        return -1;
    }
}
