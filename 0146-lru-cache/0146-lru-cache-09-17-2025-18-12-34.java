class Node{
    Node next;
    Node prev;
    int key;
    int val;
    Node(){
        this.key = -1;
        this.val = -1;
        this.next = null;
        this.prev = null;
    }
    Node(int key, int val){
        this.key = key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
}

class LRUCache {
    int cap;
    int size;
    Node head;
    Node tail;
    Map<Integer, Node> map;
    public LRUCache(int capacity) {
        head = new Node();
        tail = new Node();
        head.next = tail;
        tail.prev = head;
        cap = capacity;
        size = 0;
        map = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        this.delete(node);
        this.insertAfterHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            delete(node);
            node.val = value;
            insertAfterHead(node);
            return;
        }
        Node newNode = new Node(key, value);
        insertAfterHead(newNode);
        map.put(key, newNode);
        if(size == cap) {
            map.remove(tail.prev.key);
            delete(tail.prev);
        }
        else size++;
    }
    public void delete(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    public void insertAfterHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        node.prev = head;
        head.next = node;
    }
}
// cap = 2
// size = 2
// 2,1  1,1
// -1 1 2 -1

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */