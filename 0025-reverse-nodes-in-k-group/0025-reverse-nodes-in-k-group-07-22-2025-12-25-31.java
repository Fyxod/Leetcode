/**
 * Definition for singly-linked list.
 * public class ListListNode {
 *     int val;
 *     ListListNode next;
 *     ListListNode() {}
 *     ListListNode(int val) { this.val = val; }
 *     ListListNode(int val, ListListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        boolean first = true;
        int cnt = 0;
        ListNode last = null;
        while(temp != null){
            ListNode end = temp;
            while(cnt != k && end != null){
                end = end.next;
                cnt++;
            }
            if(cnt != k) break;
            ListNode prev = null;
            ListNode start = temp;
            while(start != end){
                ListNode next = start.next;
                start.next = prev;
                prev = start;
                start = next;
            }
            if(first){
                first = false;
                head = prev;
            }
            temp.next = end;
            if(last != null) last.next = prev;
            cnt = 0;
            last = temp;
            temp = end;
        }
        return head;
    }
}