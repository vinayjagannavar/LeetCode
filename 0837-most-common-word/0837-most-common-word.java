class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {
        // Step 1: Convert to lowercase and replace punctuation
        String para = paragraph.toLowerCase();
        String result = para.replaceAll("[^a-zA-Z0-9\\s]", " ");
        String[] words = result.split("\\s+");

        // Step 2: Create a map to count occurrences of each word
        Map<String, Integer> map = new HashMap<>();
        HashSet<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Step 3: Count words that are not banned
        for (String word : words) {
            if (!bannedSet.contains(word) && !word.isEmpty()) {
                map.put(word, map.getOrDefault(word, 0) + 1);
            }
        }

        // Step 4: Find the most common word
        String mostCommon = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommon = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommon;
    }
}
