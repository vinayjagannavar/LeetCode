class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) return "";

        Map<Character, Integer> targetCount = new HashMap<>();
        for (char c : t.toCharArray()) {
            targetCount.put(c, targetCount.getOrDefault(c, 0) + 1);
        }

        Map<Character, Integer> windowCount = new HashMap<>();
        int left = 0, right = 0;
        int required = targetCount.size();
        int formed = 0;

        int[] ans = {-1, 0, 0}; // length, start, end

        while (right < s.length()) {
            char c = s.charAt(right);
            windowCount.put(c, windowCount.getOrDefault(c, 0) + 1);

            if (targetCount.containsKey(c) && 
                windowCount.get(c).intValue() == targetCount.get(c).intValue()) {
                formed++;
            }

            // Try and contract the window till the point it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }

                windowCount.put(c, windowCount.get(c) - 1);
                if (targetCount.containsKey(c) && 
                    windowCount.get(c).intValue() < targetCount.get(c).intValue()) {
                    formed--;
                }
                left++;
            }

            right++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
