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
        //edge case 1 that is a single element is to be reversed or linked list has only one element
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
        //what if it is to be reversed from the first element itself
        //in that case head1 = null and head 1 = head2
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
        //doesnt matter if head1 is null
        //ptr2_2 travels through ptr2 list from the start
        ListNode ptr2_2 = head2;
        while(pos<right)
        {
            ptr2_2 = ptr2_2.next;
            pos++;
        }
        head3 = ptr2_2.next;
        ptr2_2.next = null;
        //Reverse the ptr2 list
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
        //reverse code ends here
        //if head1 is null that is if ptr1 list is empty 
        if(head1==null)
        {
            head1 = head2;
        }
        //basically navigate ptr2 using head2 if ptr1 is empty 
        //if ptr1 is not empty get to the end of ptr1 using head 1 
        else
        {
            ListNode ptr1_1 = head1;
            while(ptr1_1.next!=null)
            {
                ptr1_1 = ptr1_1.next;
            }
            ptr1_1.next = head2;
        }
        //at the end of ptr1 join ptr2 
        //ptr1_2 travels the ptr1 list
        ListNode ptr1_2 = head1;
        while(ptr1_2.next!=null)
        {
            ptr1_2 = ptr1_2.next;
        }
        //at the end of (ptr1+ptr2) list add the ptr3 list
        ptr1_2.next = head3;
        // the head of ptr1 can now access all (ptr1+ptr2+ptr3) lists
        return head1;

    }
}