class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int[] targetInterval = times[targetFriend];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        List<Integer> chair = new ArrayList<>();

        for (int i = 0; i < times.length; i++) {
            int[] person = times[i];
            int arrival = person[0];
            int departure = person[1];

            int j = 0;
            for (j = 0; j < chair.size(); j++) {

                if (chair.get(j) <= arrival) {
                    chair.set(j, departure); 
                    break;
                }
            }

            if (j == chair.size()) {
                chair.add(departure); 
            }

            if (person[0] == targetInterval[0] && person[1] == targetInterval[1]) {
                return j;
            }
        }
        return 0;
    }
}