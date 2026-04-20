import java.util.*;

class Node{
    int key, val;
    Node next, prev;

    Node(int key, int value){
        this.key = key;
        this.val = value;
    }
}

class LRUCache {
    Node head, tail;
    Map<Integer, Node> map;
    int cap;
    public LRUCache(int capacity) {
        this.cap = capacity;
        map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = map.get(key);
        if(node == null) return -1;
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
        if(map.size() == cap){
            Node node = tail.prev;
            map.remove(node.key);
            remove(node);
        }
        Node node = new Node(key, value);
        add(node);
        map.put(key, node);
    }
    void addToFront(Node node){
        remove(node);
        add(node);
    }
    void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }
    void remove(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}
