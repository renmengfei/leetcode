public class Solution {
   public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
	dummy.next = head;
	ListNode slow=dummy, fast=dummy;
	for(int i=0;i<n;i++){
		fast=fast.next;
	}
	while(fast.next!=null){
		fast =fast.next;
		slow = slow.next;
	}
	// bug: slow.next=fast是不对的，对于{1},1不能消除
	slow.next = slow.next.next;
	return dummy.next;
    }
}
