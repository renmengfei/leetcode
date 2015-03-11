
public class Solution {
    public ListNode rotateRight(ListNode head, int n) {
        if(head==null) return null;
        int size = 1;
        ListNode newhead=head;
        ListNode ptr = head;
        while(ptr.next!=null){
            ptr=ptr.next;
            size++;
        }
        //make cycle
        ptr.next=head;
	//bug: 对n必须取％,否则可能size-n-1<0 ，因为是cycle
        for(int i=0;i<size-n%size-1;i++){
            newhead = newhead.next;
        }
        ListNode result = newhead.next;
        newhead.next=null;
        return result;
        
    }
}
