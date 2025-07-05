/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;

        ListNode slow = head, fast = head;
        int count = 1;
        while(fast != null && fast.next != null){
            count++;
            slow = slow.next;
            fast = fast.next.next;
        }
        int length;
        if(fast != null){
            length = count*2 - 1;
        }
        else length = (count - 1) * 2;

        n = n + 1;
        length = length + 1;
        ListNode temp = new ListNode(0, head);
        ListNode curr = temp;
        while(n != length){
            curr = curr.next;
            length--;
        }
        curr.next = curr.next.next;
        temp = temp.next;
        return temp;
    }
}