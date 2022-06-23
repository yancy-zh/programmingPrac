package demos;


public class linkedList {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	/*给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。

请你将两个数相加，并以相同形式返回一个表示和的链表。

你可以假设除了数字 0 之外，这两个数都不会以 0 开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
*/
    	ListNode head = null, tail = null; //store the result
    	int carry = 0; //进位到下个节点
    	// 遍历一个链表
    	while (l1 != null || l2 != null) {
			int n1 = (l1 != null? l1.val:0);//该位为null则补0，说明两个数长度不一样，注意补上的0出现在数的头部不是尾部
			int n2 = (l2 != null? l2.val:0);
			int sum = n1 + n2 + carry;
			if (head==null) {
				//第一个位
				head = tail = new ListNode(sum%10); //此位置处的两数和
			} else {
				//非第一个位
				tail.next = new ListNode(sum%10);//此位置处的两数和
				tail = tail.next;
			}
			carry = sum/10;
			if (l1 != null) {
				l1 =l1.next;
			}
			if (l2 != null) {
				l2 =l2.next;
			}
		}
    	if (carry > 0) {//所有位已经加完，还有不为零的carry需要进位
			tail.next = new ListNode(carry);
		}
    	return head;
    }
}
