/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int l1 = 0, l2 = 0;
        ListNode temp = headA;
        while(temp != null){
            l1++;
            temp = temp.next;
        }
        temp = headB;
        while(temp != null){
            l2++;
            temp = temp.next;
        }
        ListNode temp1 = headA, temp2 = headB;
        if(l1 > l2){
            int diff = l1 - l2;
            while(diff-- > 0){
                temp1 = temp1.next;
            }
        }
        else{
            int diff = l2 - l1;
            while(diff-- > 0){
                temp2 = temp2.next;
            }
        }

        while(temp1 != null && temp2 != null){
            if(temp1 == temp2) return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return null;
    }
}