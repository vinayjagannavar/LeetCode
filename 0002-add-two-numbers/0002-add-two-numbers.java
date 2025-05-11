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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dumy = new ListNode(-1);
        ListNode current = dumy;
        int carry = 0;

        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            int rem = sum % 10;
            current.next = new ListNode(rem);
            l1=l1.next;
            l2=l2.next;
            current = current.next;
        }

        while(l1 != null){
            int sum = l1.val + carry;
            carry = sum / 10;
            int rem = sum % 10;
            current.next = new ListNode(rem);
            l1=l1.next;
            current = current.next;
        }

        while(l2 != null){
            int sum = l2.val + carry;
            carry = sum / 10;
            int rem = sum % 10;
            current.next = new ListNode(rem);
            l2=l2.next;
            current = current.next;
        }

        if(carry>0){
            current.next = new ListNode(carry);
        }

        return dumy.next;

    }
}