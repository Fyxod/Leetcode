class LRUCache {
    class Node{
        int key, val;
        Node next, prev;
        Node(){
            key = -1;
            val = -1;
            next = null;
            prev = null;
        }
        Node(int key, int val){
            this.key = key;
            this.val = val;
            next = null;
            prev = null;
        }
    }
    int cap;
    int size;
    Map<Integer, Node> map = new HashMap<>();
    Node head;
    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        head = new Node();
        head.next = head;
        head.prev = head;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        addToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            addToFront(node);
            return;
        }
        if(size == cap){
            map.remove(head.prev.key);
            deleteNode(head.prev);
        }
        else size++;
        Node node = new Node(key, value);
        addToFront(node);
        map.put(key, node);
    }
    void addToFront(Node node){
        deleteNode(node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    void deleteNode(Node node){
        if(node.prev != null) node.prev.next = node.next;
        if(node.next != null) node.next.prev = node.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */