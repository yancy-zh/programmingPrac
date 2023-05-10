package algorithms;

public class RemoveDuplicateFromSortedLinkedList
{
	
	// Definition for singly-linked list.
	public class ListNode
	{
		int val;
		ListNode next;
		
		ListNode()
		{
		}
		
		ListNode(int val)
		{
			this.val = val;
		}
		
		ListNode(int val, ListNode next)
		{
			this.val = val;
			this.next = next;
		}
	}
	
	public ListNode deleteDuplicates(ListNode head)
	{
		ListNode sentinel = new ListNode(0, head);
		ListNode predecessor = sentinel;
		while (head != null)
		{
			if (head.next != null && head.next.val == head.val)
			{
				while (head.next != null && head.next.val == head.val)
				{
					head = head.next;
					
				}
				predecessor.next = head.next;
			}
			else
			{
				predecessor = predecessor.next;
			}
			head = head.next;
		}
		return sentinel.next;
	}
}
