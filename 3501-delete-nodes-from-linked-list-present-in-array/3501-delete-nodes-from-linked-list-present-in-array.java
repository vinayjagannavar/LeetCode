class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> values = new HashSet<Integer>();
        for(int i : nums){
            values.add(i);
        }

        ListNode temp = new ListNode(0, head);
        ListNode p = temp;
        while(temp.next != null){
            if(values.contains(temp.next.val)){
                temp.next = temp.next.next;
            }
            else{
                temp = temp.next;
            }
        }
        return p.next;
    }
}