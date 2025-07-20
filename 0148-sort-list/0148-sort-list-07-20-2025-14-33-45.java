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
        return mergeSort(head);
    }
    ListNode mergeSort(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode mid = findMid(head);
        ListNode right = mergeSort(mid.next);
        mid.next = null;
        ListNode left = mergeSort(head);
        return merge(left, right);
    }
    ListNode merge(ListNode left, ListNode right){
        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while(left != null && right != null){
            if(left.val > right.val){
                temp.next = right;
                right = right.next;
            }
            else{
                temp.next = left;
                left = left.next;
            }
            temp = temp.next;
            if(right != null) temp.next = right;
            else temp.next = left;
        }

        return dummy.next;
    }
    ListNode findMid(ListNode head){
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}