// Method 1: Recursion
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        ListNode newhead = reverseList(head.next);
        head.next.next=head;
        head.next=null;
        return newhead;
    }
}

// Method 2: Iteration
public class Solution {
    public ListNode reverseList(ListNode head) {
        // newhead 从reverse的后向前
        ListNode newhead = null;
        
        while(head!=null){
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        return newhead;
    }
}

// Method 3: iteration, 用于reverse list ii
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null) return head;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode start = head;
        ListNode then = head.next;
        
        while(then!=null){
            start.next = then.next;
            then.next = dummy.next;
            dummy.next = then;
            then = start.next;
        }
        
        return dummy.next;
      
    }
