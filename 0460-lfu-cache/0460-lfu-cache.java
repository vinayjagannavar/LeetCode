class LFUCache {
    int capacity;
    int minFreq;
    HashMap<Integer, Node> keyToNode;
    HashMap<Integer, LinkedHashSet<Node>> freqToNode; 

    class Node{
        int key;
        int val;
        int count;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
            this.count = 1;
        }
    }

    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minFreq = 0;
        this.keyToNode = new HashMap<>();
        this.freqToNode = new HashMap<>();
    }
    
    public int get(int key) {
        if(!keyToNode.containsKey(key)){
            return -1;
        }

        Node node = keyToNode.get(key);
        int oldFreq = node.count;

        freqToNode.get(oldFreq).remove(node);

        if(freqToNode.get(oldFreq).isEmpty()){
            freqToNode.remove(oldFreq);

            if(minFreq == oldFreq){
                minFreq++;
            }
        }

        node.count++;

        freqToNode.computeIfAbsent(node.count,k -> new LinkedHashSet<>()).add(node);

        return node.val;
    }
    
    public void put(int key, int value) {

        if (capacity == 0) {
            return; // Cache with 0 capacity, nothing can be added
        }

        if(keyToNode.containsKey(key)){
            Node node = keyToNode.get(key);
            node.val = value;
            get(key);
            return;
        }
        
        if(keyToNode.size()>=capacity){
            Node evictNode = freqToNode.get(minFreq).iterator().next();
            freqToNode.get(minFreq).remove(evictNode);
            if (freqToNode.get(minFreq).isEmpty()) {
                freqToNode.remove(minFreq);
            }
            keyToNode.remove(evictNode.key);
        }

        Node node = new Node(key,value);
        keyToNode.put(key, node);
        freqToNode.computeIfAbsent(node.count,k -> new LinkedHashSet<>()).add(node);
        minFreq = 1; 
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */