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
     int[] arr;
     int f,r,c;
    public MyCircularDeque(int k) {
        arr=new int[k];
        f=-1;
        r=-1;
        c=k;
    }
    
    public boolean insertFront(int value) {
        if(isFull())return false;
        if(isEmpty())f=r=0;
        else f=(f-1+c)%c;
        arr[f]=value;
        return true;
    }
    
    public boolean insertLast(int value) {
        if(isFull())return false;
        if(isEmpty())f=r=0;
        else r=(r+1)%c;
        arr[r]=value;
        return true;
    }
    
    public boolean deleteFront() {
        if(isEmpty())return false;
        if(f==r)f=r=-1;
        else f=(f+1)%(c);
        return true;
    }
    
    public boolean deleteLast() {
        if(isEmpty())return false;
        if(f==r)f=r=-1;
        else r=(r-1+c)%c;
        return true;
    }
    
    public int getFront() {
        if(isEmpty())return -1;
        return arr[f];
    }
    
    public int getRear() {
        if(isEmpty())return -1;
        return arr[r];
    }
    
    public boolean isEmpty() {
        return f==-1;
    }
    
    public boolean isFull() {
        return ((f-1+c)%c)==r;
        //return ((f-1+c)%c)==r;
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