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
    public ListNode reverseList(ListNode head) {
        if(head==null)
		{
			return head;
		}
        ListNode Prev = null;
		ListNode Current = head;
		ListNode Next = Current.next;

		while(Current!=null)
		{
			Current.next = Prev;
			Prev = Current;
			Current = Next;
			if(Next!=null)
				Next =Current.next;
			else
				Next=null;
		}
		head = Prev;
        return head;
    }
}