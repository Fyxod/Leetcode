/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node dummyNode = new Node(-1);
        Node temp = head;
        Map<Node, Integer> map1 = new HashMap<>();
        int i = 0;
        while(temp != null){
            map1.put(temp, i);
            temp = temp.next;
            i++;
        }
        temp = head;
        Node temp2 = dummyNode;
        Map<Integer, Node> map2 = new HashMap<>();
        i = 0;
        while(temp != null){
            temp2.next = new Node(temp.val);
            temp2 = temp2.next;
            map2.put(i, temp2);
            temp = temp.next;
            i++;
        }
        temp = head;
        temp2 = dummyNode.next;

        while(temp2 != null){
            int index = -1;
            if(temp.random != null){
                index = map1.getOrDefault(temp.random, -1);
                Node random = map2.get(index);
                temp2.random = random;
            }
            temp = temp.next;
            temp2 = temp2.next;
            index++;
        }
        return dummyNode.next;
    }
}