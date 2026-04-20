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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode prev = null;
        ListNode curr = head;
        int pos = 1;
        while(pos != left){
            prev = curr;
            curr = curr.next;
            pos++;
        }
        ListNode leftNode = curr;
        while(pos != right){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            pos++;
        }
        if(left != right && leftNode.next != null){
            leftNode.next.next = curr;
        }
        leftNode.next = curr.next;
        if(left != right) curr.next = prev;
        if(left == 1) return curr;
        return head;
    }
}