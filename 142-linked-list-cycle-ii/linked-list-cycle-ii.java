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
    public ListNode detectCycle(ListNode head) {
        ListNode FastPointer = head;
        ListNode SlowPointer = head;
        Boolean check = false;

        while(FastPointer!=null && FastPointer.next!=null)
        {
            SlowPointer = SlowPointer.next;
            FastPointer = FastPointer.next.next;

            if(FastPointer == SlowPointer)
            {
                check = true;
                break;
            }
        }
        if(check==true)
        {
            SlowPointer = head;
            int position = 0;
            while(SlowPointer!=FastPointer)
            {
                SlowPointer = SlowPointer.next;
                FastPointer = FastPointer.next;
            }
                return SlowPointer;
        }
            return null;

        }
        
    }
