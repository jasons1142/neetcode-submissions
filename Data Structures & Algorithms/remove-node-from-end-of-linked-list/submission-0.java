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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int length = 0;
        ListNode trav = head;

        while (trav != null) {
            length++;
            trav = trav.next;
        }

        if (n == length) {
            return head.next;
        }

        ListNode trav2 = head;

        for (int i = 1; i < length - n; i++) {
            trav2 = trav2.next;
        }

        trav2.next = trav2.next.next;

        return head;
    }
}
