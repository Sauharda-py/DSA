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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int pos = 1;
        ListNode ptr1 = head;
        ListNode ptr2=head;

        ListNode head1;
        ListNode head2;
        ListNode head3;
        if(left==right)
        {
            return head;
        }
        while(pos<left)
        {
            ptr2 = ptr2.next;
            pos++;
        }
        head2 = ptr2;
        if(left==1)
        {
            head1=null;
        }
        else
        {
            head1 = head;
            while(ptr1.next!=ptr2)
            {
                ptr1=ptr1.next;
            }
            ptr1.next = null;
        }
        ListNode ptr2_2 = head2;
        while(pos<right)
        {
            ptr2_2 = ptr2_2.next;
            pos++;
        }
        head3 = ptr2_2.next;
        ptr2_2.next = null;

        ListNode Prev = null;
		ListNode Current = head2;
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
        head2 = Prev;
        if(head1==null)
        {
            head1 = head2;
        }
        else
        {
            ListNode ptr1_1 = head1;
            while(ptr1_1.next!=null)
            {
                ptr1_1 = ptr1_1.next;
            }
            ptr1_1.next = head2;
        }
        ListNode ptr1_2 = head1;
        while(ptr1_2.next!=null)
        {
            ptr1_2 = ptr1_2.next;
        }
        ptr1_2.next = head3;
        return head1;

    }
}