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
        if(left == right) return head;

        ListNode dummy = new ListNode();
        dummy.next = head;
        int ind = 0;
        ListNode curr = dummy;

        while(ind < left - 1){
            curr = curr.next;
            ind++;
        }
        ListNode leftB = curr;
        ListNode leftNode = curr.next;

        while(ind < right){
            curr = curr.next;
            ind++;
        }
        ListNode rightB = curr.next;
        ListNode rightNode = curr;

        ListNode prev = null;
        curr = leftNode;

        while(curr != rightB){
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        leftB.next = rightNode;
        leftNode.next = rightB;

        return dummy.next;
    }
}