public ListNode reverseBetween(ListNode head, int m, int n) {
	if (head == null)
		return null;
	ListNode dummy = new ListNode(0); 
	dummy.next = head;
	
	// pre是m之前的node，用pre.next保证reverse	
	ListNode pre = dummy; 
	for (int i = 0; i < m - 1; i++)
		pre = pre.next;
	
	// start永远不变，是m那个node，一次reverse一个
	ListNode start = pre.next; 
	ListNode then = start.next; 

	for(int i=m;i<n;i++){
		start.next = then.next;
		then.next = pre.next;
		pre.next = then;
		then = start.next;
	}

	return dummy.next;
}
