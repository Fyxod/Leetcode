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
    public ListNode[] splitListToParts(ListNode head, int k) {
        int size = 0;
        ListNode temp = head;
        while(temp != null){
            temp = temp.next;
            size++;
        }

        ListNode[] ans = new ListNode[k]; 
        int res = size / k;
        int div = res == 0 ? 1 : res;
        int extras = 0;
        if(div * k < size) extras = size - div * k;
        int ind = 0;
        ListNode ptr = head;
        while(extras > 0){
            int cnt = 0;
            temp = ptr;
            while(cnt < div){
                temp = temp.next;
                cnt++;
            }
            ans[ind++] = ptr;
            ptr = temp.next;
            temp.next = null;
            extras--;
        }

        while(ind < k && ptr != null){
            int cnt = 0;
            temp = ptr;
            while(cnt < div - 1){
                temp = temp.next;
                cnt++;
            }
            ans[ind++] = ptr;
            ptr = temp.next;
            temp.next = null;
        }

        return ans;
    }
}