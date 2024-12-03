class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();

        int j = 0; // Pointer for spaces array
        int n = spaces.length;

        for (int i = 0; i < s.length(); i++) {
            // Add a space if the current index matches the next space position
            if (j < n && i == spaces[j]) {
                sb.append(' ');
                j++;
            }

            // Add the current character
            sb.append(s.charAt(i));
        }

        return sb.toString();
    }
}
