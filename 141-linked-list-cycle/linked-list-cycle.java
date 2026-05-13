/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        ListNode SlowPointer = head;
        ListNode FastPointer = head;

        while(FastPointer!=null && FastPointer.next!=null)
        {
            SlowPointer = SlowPointer.next;
            FastPointer = FastPointer.next.next;

            if(FastPointer == SlowPointer)
                return true;
        }
        return false;
    }
}