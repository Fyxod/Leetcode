class Node{
    Node next, prev;
    int key, val, freq;
    Node(int key, int val){
        this.key = key;
        this.val = val;
        freq = 1;
    }
}
class DLL{
    Node head;
    int size;
    int freq;
    DLL(int freq){
        this.freq = freq;
        head = new Node(-1, -1);
        head.prev = head;
        head.next = head;
    }

    void add(Node node){
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
        size++;
    }
    void remove(Node node){
        if(node.freq != freq) return;
        size--;
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    Node removeMin(){
        Node last = head.prev;
        last.prev.next = head;
        head.prev = last.prev;
        size--;
        return last;
    }
}

class LFUCache {
    int cap, size;
    Map<Integer, Node> map;
    Map<Integer, DLL> freq;
    int minFreq;
    public LFUCache(int capacity) {
        cap = capacity;
        size = 0;
        minFreq = 1;
        map = new HashMap<>();
        freq = new HashMap<>();
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        increaseFrequency(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            increaseFrequency(node);
            return;
        }
        size++;
        Node node = new Node(key, value);
        freq.computeIfAbsent(1, k -> new DLL(1)).add(node);
        if(size > cap){
            Node rem = freq.get(minFreq).removeMin();
            map.remove(rem.key);
            size--;
        }
        minFreq = 1;
        map.put(key, node);
    }
    void increaseFrequency(Node node){
        if(node.freq == minFreq && freq.get(node.freq).size == 1) minFreq++;
        freq.get(node.freq).remove(node);
        node.freq++;
        freq.computeIfAbsent(node.freq, k -> new DLL(node.freq)).add(node);
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */