class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {
            String freqString = getFrequencyString(str);
            map.computeIfAbsent(freqString, k -> new ArrayList<>()).add(str);
        }

        return new ArrayList<>(map.values());
    }

    private String getFrequencyString(String str) {
        int[] alpha = new int[26];
        
        for (char c : str.toCharArray()) {
            alpha[c - 'a']++;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            sb.append('#').append(alpha[i]);
        }

        return sb.toString();
    }
}
