// class MyCalendar {
//     List<int[]> calendar;

//     public MyCalendar() {
//         calendar = new ArrayList<>();
//     }
    
//     public boolean book(int start, int end) {
        
//         for (int[] event : calendar) {
            
//             if (event[0] < end && start < event[1]) {
//                 return false; 
//             }
//         }
        
//         calendar.add(new int[]{start, end});
//         return true;
//     }
// }

class MyCalendar {

    class Node {
        int start;
        int end;
        Node left,right;

        public Node(int start,int end){
            this.start = start;
            this.end = end;
        }
    }

    Node root;

    public MyCalendar() {
        
    }
    
    public boolean book(int start, int end) {
        if(root == null){
            root = new Node(start,end);
            return true;
        }
        Node curr = root;
        while(curr != null){
            if(end <= curr.start){
                if(curr.left == null){
                    curr.left = new Node(start,end);
                    return true;
                }
                curr = curr.left;
            }
            else if(start >= curr.end){
                if(curr.right == null){
                    curr.right = new Node(start,end);
                    return true;
                }
                curr = curr.right;
            }
            else return false;
        }
        return false;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */