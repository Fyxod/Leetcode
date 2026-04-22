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
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        if(fast != null){
            ListNode next = slow.next;
            slow.next = null;
            slow = next;
        }
        else{
            prev.next = null;
        }

        prev = null;
        while(slow != null){
            ListNode next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }

        ListNode n1 = head, n2 = prev;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(n1 != null){
            temp.next = n1;
            temp = n1;
            n1 = n1.next;
            if(n2 != null){
                temp.next = n2;
                temp = n2;
                n2 = n2.next;
            }
        }
    }
}