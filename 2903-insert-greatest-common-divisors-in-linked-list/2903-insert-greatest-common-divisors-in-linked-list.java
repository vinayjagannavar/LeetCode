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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;  
        }

        ListNode current = head;

        while (current != null && current.next != null) {
            int gcdValue = findGCD(current.val, current.next.val);
            ListNode newNode = new ListNode(gcdValue);

            newNode.next = current.next;
            current.next = newNode;

            current = newNode.next;
        }

        return head;
    }

    private static int findGCD(int a, int b) {
        // Base case: if b is 0, GCD is a
        if (b == 0) {
            return a;
        }
        // Recursively call the method with b and the remainder of a / b
        return findGCD(b, a % b);
    }
}