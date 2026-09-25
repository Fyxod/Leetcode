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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode slow = head, fast = head, prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode A = sortList(prev.next);
        prev.next = null;
        ListNode B = sortList(head);
        return merge(A, B);
    }
    public ListNode merge(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        ListNode temp1 = list1, temp2 = list2;

        while(temp1 != null && temp2 != null){
            if(temp1.val < temp2.val){
                curr.next = temp1;
                temp1 = temp1.next;
            }
            else{
                curr.next = temp2;
                temp2 = temp2.next;
            }
            curr = curr.next;
        }

        if(temp1 != null) curr.next = temp1;
        else curr.next = temp2;

        return dummy.next;
    }
}