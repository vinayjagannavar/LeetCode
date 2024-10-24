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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        if(lists.length == 0){
            return null;
        }

        for(int i=0; i<lists.length; i++){
            ListNode current = lists[i];
            while(current!=null){
                pq.offer(current.val);
                current = current.next;
            }
        }

        ListNode dummy = new ListNode(-1);

        ListNode head = dummy;

        while(!pq.isEmpty()){
            head.next = new ListNode(pq.poll());
            head = head.next;
        }

        return dummy.next;
    }
}