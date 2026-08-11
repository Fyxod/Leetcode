    class Node{
        Node prev;
        Node next;
        int val;
        int key;
        Node(int key, int val){
            this.val = val;
            this.key = key;
            prev = null;
            next = null;
        }
    }
class LRUCache {
    Node head;
    Map<Integer, Node> map;
    int cap, size;
    public LRUCache(int capacity) {
        cap = capacity;
        size = 0;
        map = new HashMap<>();
        head = new Node(-1, -1);
        head.next = head;
        head.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            moveToFront(node);
            node.val = value;
            return;
        }
        size++;
        Node node = new Node(key, value);
        map.put(key, node);
        moveToFront(node);
        if(size > cap){
            Node last = head.prev;
            delete(last);
            map.remove(last.key);
            size--;
        }
    }
    void moveToFront(Node node){
        delete(node);
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    void delete(Node node){
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