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
    public ListNode partition(ListNode head, int x) {
        ListNode first = new ListNode(0);
        ListNode firstmark = first;
        ListNode second = new ListNode(0);
        ListNode secondmark = second;
        ListNode curr = head;
        while(curr != null){
            ListNode nextcurr = curr.next;
            if(curr.val < x){
                first.next = curr;
                first = first.next;
                first.next = null;
            }
            else{
                second.next = curr;
                second = second.next;
                second.next = null;
            }

            curr = nextcurr;
            
        }
        first.next = secondmark.next;
        return firstmark.next;


    }
}