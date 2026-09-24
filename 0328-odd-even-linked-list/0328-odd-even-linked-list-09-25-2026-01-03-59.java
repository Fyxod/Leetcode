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
        ListNode oddHead = new ListNode(-1);
        ListNode evenHead = new ListNode(-1);
        ListNode odd = oddHead, even = evenHead;

        ListNode curr = head;
        while(curr != null && curr.next != null){
            odd.next = curr;
            even.next = curr.next;
            curr = curr.next.next;
            odd = odd.next;
            even = even.next;
        }
        if(curr != null){
            odd.next = curr;
            odd = odd.next;
        }
        even.next = null;
        odd.next = evenHead.next;
        return oddHead.next;

    }
}