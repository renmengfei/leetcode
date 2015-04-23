// Method 1: iteration
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode ptr = head;
        ListNode prev = dummy;
        while(ptr!=null){
            if(ptr.val!=val){
                prev = ptr;
            }
            else{
                prev.next = ptr.next;
            }
            ptr=ptr.next;
        }
        return dummy.next;
    }
}

// Method 2: recursion
    public ListNode removeElements(ListNode head, int val) {
        if(head==null) return null;
        head.next = removeElements(head.next, val);
        return head.val==val? head.next: head;
    }
