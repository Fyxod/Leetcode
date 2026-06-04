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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int len1 = 0, len2 = 0;
        ListNode temp = l1;
        while(temp != null){
            temp = temp.next;
            len1++;
        }
        temp = l2;
        while(temp != null){
            temp = temp.next;
            len2++;
        }

        ListNode small = len1 < len2 ? l1 : l2;
        ListNode big = small == l1 ? l2 : l1;

        int carry = 0;
        ListNode temp1 = small;
        ListNode temp2 = big;
        while(temp1 != null){
            int sum = temp1.val + temp2.val + carry;
            carry = sum / 10;
            temp2.val = sum % 10;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        while(temp2 != null && carry != 0){
            int sum = carry + temp2.val;
            carry = sum / 10;
            temp2.val = sum % 10;
            temp2 = temp2.next;
        }
        if(carry != 0){
            temp2 = big;
            while(temp2.next != null) temp2 = temp2.next;
            temp2.next = new ListNode(carry);
        }

        return big;
    }
}