public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;

        ListNode dum = new ListNode(0);
        dum.next = head;

        ListNode n1=dum;
        ListNode n2=head;

        while(n2!=null&&n2.next!=null){
	    n1.next = n2.next;
	    n2.next = n1.next.next;
            n1.next.next = n2;

            n1=n2;
            n2=n1.next;

        }

        return dum.next;
    }
