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
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode temp = head, prev = null;
        while(temp != slow){
            ListNode next = temp.next;
            temp.next = prev;
            prev = temp;
            temp = next;
        }
        if(fast != null) slow = slow.next;
        ListNode n1 = prev, n2 = slow;
        while(n1 != null && n2 != null){
            if(n1.val != n2.val) return false;
            n1 = n1.next;
            n2 = n2.next;
        }
        return true;
    }
}