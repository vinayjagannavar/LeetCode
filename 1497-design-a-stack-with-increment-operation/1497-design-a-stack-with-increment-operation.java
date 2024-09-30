// class CustomStack {

//     class ListNode{
//         int val;
//         ListNode next;

//         public ListNode(int val){
//             this.val = val;
//         }
//     }

//     private ListNode head;
//     int maxSize;
//     int size = 0;
//     public CustomStack(int maxSize) {
//         this.maxSize = maxSize;
//         head = new ListNode(-1);
//     }
    
//     public void push(int x) {
//         if(size < maxSize){
//             ListNode node = new ListNode(x);
//             if(head.next == null){
//                 head.next = node;
//             }
//             else{
//                 node.next = head.next;
//                 head.next = node;
//             }
//             size++;
//         }

//         return;
//     }
    
//     public int pop() {
//         if(size>0){
//             ListNode node = head.next;
//             head.next = head.next.next;
//             node.next = null;
//             size--;
//             return node.val;
//         }
        
//         return -1;
//     }
    
//     public void increment(int k, int val) {
//         if(k>=size){
//             ListNode current = head.next;
//             while(current != null){
//                 current.val = val+current.val;
//                 current = current.next;
//             }
//         }
//         else{
//             int skip = size - k;
//             ListNode current = head.next;
//             while(skip != 0){
//                 current = current.next;
//                 skip--;
//             }

//             while(current != null){
//                 current.val = val+current.val;
//                 current = current.next;
//             }

//         }
//     }
// }


class CustomStack {
    int[] stack;
    int top;

    public CustomStack(int maxSize) {
        stack = new int[maxSize];
        top = -1;
    }
    
    public void push(int x) {
        if(top < stack.length-1){
            stack[++top] = x;
        }        
    }
    
    public int pop() {
        
        return top>-1?stack[top--]:-1;
    }
    
    public void increment(int k, int val) {
        k = Math.min(k, top+1);
        for(int i = 0; i<k;i++){
            stack[i]+=val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */