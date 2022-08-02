package algorithms;

public class MyList {
//			MyList myList = new MyList();
//	ListNode head1 = new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(2, new ListNode(4, new ListNode(6))))));
//	System.out.println(myList.sortList(head1));
	//归并法排序
    public ListNode sortList(ListNode head) {
        return sortList(head, null);
    }

    public ListNode sortList(ListNode head, ListNode tail) {
        if (head == null) {
            return head;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        ListNode mid = slow;
        ListNode list1 = sortList(head, mid);
        ListNode list2 = sortList(mid, tail);
        ListNode sorted = merge(list1, list2);
        return sorted;
    }

    public ListNode merge(ListNode head1, ListNode head2) {
    	// 归并排序
        ListNode dummyHead = new ListNode(0);
        ListNode temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.val <= temp2.val) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
    
    public static ListNode createLinkedListFromArray(int[] array) {
    	ListNode head = new ListNode(array[0]);
    	ListNode pointer = head;
    	for (int i = 1; i < array.length; i++) {
			ListNode listNode = new ListNode(array[i]);
			pointer.next = listNode;
			pointer = pointer.next;
		}
    	return head;
    }
    
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		/*合并两个有序链表 21
		 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
		 * int[] nums1 = {1,2,4}; int[] nums2 = {1,3,4}; ListNode l1 =
		 * MyList.createLinkedListFromArray(nums1); ListNode l2 =
		 * MyList.createLinkedListFromArray(nums2); ListNode mergedListNode =
		 * MyList.mergeTwoLists(l1, l2);
		 */
        if (l1 == null) {
            return l2;
        } else if (l2 == null) {
            return l1;
        } else if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}
