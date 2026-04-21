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
        if(head == null) return head;
        int n = 1;
        ListNode temp = head;
        while(temp.next != null){
            n++;
            temp = temp.next;
        }

        k = k % n;
        if(k == 0) return head;
        int t = n - k - 1;
        ListNode last = temp;
        temp = head;
        while(t > 0){
            temp = temp.next;
            t--;
        }
        ListNode ans = temp.next;
        temp.next = null;
        last.next = head;
        return ans;
    }
}