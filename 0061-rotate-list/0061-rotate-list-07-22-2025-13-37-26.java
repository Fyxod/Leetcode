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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) return head;
        int cnt = 0;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        while(fast != null && cnt != k + 1){
            fast = fast.next;
            cnt++;
        }
        if(cnt != k + 1 || fast == null) return rotateRight(head, k % (cnt - 1));
        ListNode end = null;
        while(fast != null){
            if(fast.next == null) end = fast;
            slow = slow.next;
            fast = fast.next;
        }
        
        ListNode newHead = slow.next;
        slow.next = null;
        end.next = head;
        return newHead;
    }
}