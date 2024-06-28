class Solution {
    public long maximumImportance(int n, int[][] roads) {
        int[] freq = new int[n];
        for (int[] road: roads) {
            freq[road[0]]++;
            freq[road[1]]++;
        }
        Arrays.sort(freq);

        long importanceSum = 0;
        for (int i = 0; i < n; i++) {
            importanceSum += freq[i] * (i + 1L);
        }

        return importanceSum;
    }
}