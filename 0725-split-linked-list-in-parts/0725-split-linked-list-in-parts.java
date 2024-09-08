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
    public ListNode[] splitListToParts(ListNode head, int k) {
        ListNode[] list = new ListNode[k];
        ListNode current = head;

        int count = 0;

        while(current != null){
            count++;
            current = current.next;
        }

        int q = count/k;
        int r = count%k;

        current = head;

        for(int i=0 ; i<k; i++){
            ListNode partHead = current;
            ListNode prev = null;
            int partSize = q + (r > 0 ? 1 : 0);

             for (int j = 0; j < partSize; j++) {
                prev = current;
                if (current != null) {
                    current = current.next;
                }
            }

            if (prev != null) {
                prev.next = null;
            }

            list[i] = partHead;

            if (r > 0) {
                r--; 
            }
        }

        return list;
    }
}