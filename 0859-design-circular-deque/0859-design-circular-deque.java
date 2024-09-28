// class MyCircularDeque {
//     int size;
//     int count = 0;

//     class ListNode{
//         int val;
//         ListNode next;
//         ListNode prev;

//         public ListNode(int val){
//             this.val = val;
//         }
//     }

//     ListNode head;
//     ListNode tail;
//     public MyCircularDeque(int k) {
//         size = k;
//         head = new ListNode(-1);
//         tail = new ListNode(-1);
//         head.next = tail;
//         tail.prev = head;
//     }
    
//     public boolean insertFront(int value) {
//         if(count<size){
//             ListNode current = head.next;
//             ListNode newNode = new ListNode(value);
//             head.next = newNode;
//             newNode.next = current;
//             newNode.prev = head;
//             current.prev = newNode;
//             count++;
//             return true;
//         }
//         else{
//             return false;
//         }
        
//     }
    
//     public boolean insertLast(int value) {
//         if(count<size){
//             ListNode current = tail.prev;
//             ListNode newNode = new ListNode(value);
//             tail.prev = newNode;
//             newNode.prev = current;
//             newNode.next = tail;
//             current.next = newNode;
//             count++;
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
    
//     public boolean deleteFront() {
//         if(count>0){
//             ListNode current = head.next.next;
//             head.next = current;
//             current.prev = head;
//             count--;
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
    
//     public boolean deleteLast() {
//         if(count>0){
//             ListNode current = tail.prev.prev;
//             tail.prev = current;
//             current.next = tail;
//             count--;
//             return true;
//         }
//         else{
//             return false;
//         }
//     }
    
//     public int getFront() {
//         return head.next.val;
//     }
    
//     public int getRear() {
//         return tail.prev.val;
//     }
    
//     public boolean isEmpty() {
//         return count<=0? true : false;
//     }
    
//     public boolean isFull() {
//         return count==size? true : false;
//     }
// }


class MyCircularDeque {
    private LinkedList<Integer> dq;
    private int n;

    public MyCircularDeque(int k) {
        dq = new LinkedList<>();
        n = k;
    }

    public boolean insertFront(int value) {
        if (dq.size() < n) {
            dq.addFirst(value);
            return true;
        }
        return false;
    }

    public boolean insertLast(int value) {
        if (dq.size() < n) {
            dq.addLast(value);
            return true;
        }
        return false;
    }

    public boolean deleteFront() {
        if (!dq.isEmpty()) {
            dq.removeFirst();
            return true;
        }
        return false;
    }

    public boolean deleteLast() {
        if (!dq.isEmpty()) {
            dq.removeLast();
            return true;
        }
        return false;
    }

    public int getFront() {
        return dq.isEmpty() ? -1 : dq.getFirst();
    }

    public int getRear() {
        return dq.isEmpty() ? -1 : dq.getLast();
    }

    public boolean isEmpty() {
        return dq.isEmpty();
    }

    public boolean isFull() {
        return dq.size() == n;
    }
}


/**
 * Your MyCircularDeque object will be instantiated and called as such:
 * MyCircularDeque obj = new MyCircularDeque(k);
 * boolean param_1 = obj.insertFront(value);
 * boolean param_2 = obj.insertLast(value);
 * boolean param_3 = obj.deleteFront();
 * boolean param_4 = obj.deleteLast();
 * int param_5 = obj.getFront();
 * int param_6 = obj.getRear();
 * boolean param_7 = obj.isEmpty();
 * boolean param_8 = obj.isFull();
 */