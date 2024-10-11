import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int targetArrival = times[targetFriend][0];
        int targetDeparture = times[targetFriend][1];

        Arrays.sort(times, (a, b) -> a[0] - b[0]);

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>((a, b) -> a[0] - b[0]);

        for (int i = 0; i < times.length; i++) {
            availableChairs.offer(i);
        }

        // Process each friend in order of arrival
        for (int i = 0; i < times.length; i++) {
            int[] person = times[i];
            int arrival = person[0];
            int departure = person[1];

            // Free up any chairs from friends who have already left
            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                int freedChair = occupiedChairs.poll()[1];
                availableChairs.offer(freedChair); // Chair becomes available again
            }

            // Assign the smallest available chair to the current person
            int assignedChair = availableChairs.poll();
            occupiedChairs.offer(new int[]{departure, assignedChair}); // Track when this chair will be free

            // If it's the target friend, return the assigned chair number
            if (arrival == targetArrival && departure == targetDeparture) {
                return assignedChair;
            }
        }

        return -1; // This line shouldn't be reached
    }
}
