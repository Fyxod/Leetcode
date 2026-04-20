class Node{
    int key, val;
    Node next, prev;
    Node(int key, int value){
        this.key = key;
        this.val = value;
    }
}
class LRUCache {
    Map<Integer, Node> map;
    int size;
    int cap;
    Node head;
    public LRUCache(int capacity) {
        size = 0;
        cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        head.prev = head;
        head.next = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
        remove(node);
        addToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            remove(node);
            addToFront(node);
            return;
        }
        if(size == cap){
            Node del = head.prev;
            map.remove(del.key);
            remove(del);

        }
        else size++;
        Node node = new Node(key, value);

        map.put(key, node);
        addToFront(node);
    }
    void addToFront(Node node){
        node.next = head.next;
        head.next = node;
        node.next.prev = node;
        node.prev = head;
    }
    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
