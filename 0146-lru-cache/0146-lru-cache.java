class ListNode{
    int key;
    int val;
    ListNode node;
    ListNode next;
    ListNode prev;

    public ListNode(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {

    Map<Integer, ListNode> map;
    ListNode head;
    ListNode tail;
    int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        map = new HashMap<>();
        head = new ListNode(-1,-1);
        tail = new ListNode(-1,-1);
        head.next = tail;
        tail.prev = head;
    }

    private void addNode(ListNode newNode){
        ListNode temp = head.next;
        head.next = newNode;
        newNode.prev = head;
        newNode.next = temp;
        temp.prev = newNode;
    }

    private void deleteNode(ListNode d){
        ListNode pre = d.prev;
        ListNode nex = d.next;
        pre.next = nex;
        nex.prev = pre;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }

        ListNode p = map.get(key);
        deleteNode(p);
        addNode(p);
        map.put(key,head.next);
        return head.next.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            ListNode c = map.get(key);
            deleteNode(c);
            c.val = value;
            addNode(c);
            map.put(key, head.next);
        }
        else{
            if(map.size() == size){
                ListNode prev = tail.prev;
                deleteNode(prev);
                ListNode l = new ListNode(key, value);
                addNode(l);
                map.remove(prev.key);
                map.put(key, head.next);
            }
            else{
                ListNode l = new ListNode(key, value);
                addNode(l);
                map.put(key, head.next);
            }
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */