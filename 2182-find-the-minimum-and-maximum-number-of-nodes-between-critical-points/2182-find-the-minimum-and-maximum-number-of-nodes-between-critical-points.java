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

       ListNode prev=head;
       head=head.next;

       int first_index=-1;
       int last_index=-1;

       int index=1;
       int prev_index=0;

       int min_dist=Integer.MAX_VALUE;
       int max_dist=Integer.MIN_VALUE;

       while(head.next!=null){

        if(prev.val>head.val && head.val<head.next.val   || prev.val<head.val && head.val>head.next.val){

            if(prev_index==0){
                first_index=index;
                prev_index=index;
            }
            else{
                if(min_dist>index-prev_index){
                    min_dist=index-prev_index;
                }

                prev_index=index;
            }

        }
        index++;
        prev=head;
        head=head.next;
       }

       last_index=prev_index;      

       if(min_dist==Integer.MAX_VALUE ){
         return new int[]{-1,-1};
       }
       else{
        max_dist=last_index-first_index;
        return new int[]{min_dist,max_dist};
       }

    }
}