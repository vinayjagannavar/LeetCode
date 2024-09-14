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
    public ListNode partition(ListNode head, int x) {
        if(head == null || head.next==null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode greater = dummy;

        while(greater.next!=null){
            if(greater.next.val >= x){
                break;
            }
            greater = greater.next;
        }

        ListNode current = greater.next;

        while(current !=null && current.next != null){
            if(current.next.val < x){
                ListNode temp = current.next;
                current.next = current.next.next;
                temp.next = greater.next;
                greater.next = temp;
                greater = greater.next;
            }
            else{
                current = current.next;
            }
        }

        return dummy.next;

    }
}