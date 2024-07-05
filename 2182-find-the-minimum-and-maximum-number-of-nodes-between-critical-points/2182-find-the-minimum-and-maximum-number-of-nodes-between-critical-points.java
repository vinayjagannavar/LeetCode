/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ArrayList<Integer> cpoints = new ArrayList<>();
        ListNode prev = head;
        head = head.next;
        int index = 1;

        // Traverse the linked list to find critical points
        while (head != null && head.next != null) {
            if ((head.val > prev.val && head.val > head.next.val) || 
                (head.val < prev.val && head.val < head.next.val)) {
                cpoints.add(index);
            }
            prev = head;
            head = head.next;
            index++;
        }

        // If there are fewer than two critical points, return [-1, -1]
        if (cpoints.size() < 2) {
            return new int[]{-1, -1};
        }

        // Calculate minimum and maximum distances between critical points
        int minDistance = Integer.MAX_VALUE;
        for (int i = 1; i < cpoints.size(); i++) {
            minDistance = Math.min(minDistance, cpoints.get(i) - cpoints.get(i - 1));
        }
        int maxDistance = cpoints.get(cpoints.size() - 1) - cpoints.get(0);

        return new int[]{minDistance, maxDistance};
    }
}