package demos;

import java.util.*;

/*
public class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}*/
public class ReverseLinkedList
{
	public ListNode ReverseList(ListNode head)
	{
		// create a stack
		Stack<ListNode> stack = new Stack<ListNode>();
		// null list condition
		if (head==null)
		{
			return null;
		}
		// push all nodes to the stack
		while (head != null)
		{
			stack.push(head);
			head = head.next;
		}
		// add all nodes to the new linked list
		ListNode node = stack.pop();
		ListNode dummy = node;
		while (!stack.empty())
		{
			node.next = stack.pop();
			node = node.next;
		}
		node.next = null;
		return dummy;
	}
}