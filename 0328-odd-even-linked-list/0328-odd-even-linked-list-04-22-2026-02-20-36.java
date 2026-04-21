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
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode odd = head, even = head.next, evenHead = head.next;

        while(odd != null && even != null){
            odd.next = even.next;
            if(even.next != null) even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }

        ListNode temp = head;
        while(temp.next != null) temp = temp.next;
        temp.next = evenHead;

        return head;
    }
}