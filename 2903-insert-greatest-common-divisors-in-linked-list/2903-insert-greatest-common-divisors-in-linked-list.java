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
        if(head.next == null){
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        while(first!=null && second!=null){
            ListNode newNode = new ListNode(findGCD(first.val, second.val));
            first.next = newNode;
            newNode.next = second;
            first=second;
            second = second.next;
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