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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = new ListNode(-1);
        ListNode ans = head;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(item -> item.val));
        boolean flag = true;
        while(flag){
            flag = false;
            for(int i = 0; i < lists.length; i++){
                ListNode curr = lists[i];
                if(curr != null){
                    pq.add(curr);
                    curr = curr.next;
                    lists[i] = curr;
                    flag = true;
                }
            }
            ans.next = pq.poll();
            ans = ans.next;
        }
        while(!pq.isEmpty()){
            ans.next = pq.poll();
            ans = ans.next;
        }
        if(ans != null) ans.next = null;
        return head.next;
    }
}