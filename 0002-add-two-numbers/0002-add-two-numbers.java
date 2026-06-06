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
        ListNode mark1 = l1;
        ListNode mark2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode mark = dummy;
        int carry = 0;
        while(mark1 != null && mark2 != null){
            int val = mark1.val + mark2.val;
            val = carry + val;
            ListNode next = new ListNode(val % 10);
            dummy.next = next;
            dummy = dummy.next;
            mark1 = mark1.next;
            mark2 = mark2.next;
            carry = val / 10;
        }
        if(mark1 != null){
            while(mark1 != null){
                int val = mark1.val + carry;
                ListNode next = new ListNode(val % 10);
                dummy.next = next;
                mark1 = mark1.next;
                carry = val / 10;
                dummy = dummy.next;
            }
        }
        else{
            while(mark2 != null){
                int val = mark2.val + carry;
                ListNode next = new ListNode(val % 10);
                dummy.next = next;
                mark2 = mark2.next;
                carry = val / 10;
                dummy = dummy.next;
            }
        }

        if(carry != 0){
            ListNode next = new ListNode(carry);
            dummy.next = next;
        }

        return mark.next;
    }
}