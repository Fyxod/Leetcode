class Solution {
    public Node flatten(Node head) {
        Node temp = head;
        while(temp != null){
            if(temp.child != null){
                Node next = temp.next;
                Node child = flatten(temp.child);
                temp.next = child;
                child.prev = temp;
                temp.child = null;
                while(temp.next != null) temp = temp.next;
                temp.next = next;
                if(next != null) next.prev = temp;
            }
            temp = temp.next;
        }

        return head;
    }
}