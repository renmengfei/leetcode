// Method 1: iteration
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy, end = dummy;
        ListNode start;
        
        while(end!=null){
            int count=0;
            while(end!=null && count!=k){
                end=end.next;
                count++;
            }
            if(end==null) break;
            
            start=pre.next;
            ListNode then = start.next;
            while(pre.next!=end){
                
                start.next = then.next;
                then.next = pre.next;
                pre.next = then;
                then = start.next;
            }
            pre = start;
            end = start;
        }
        
        return dummy.next;
        
    }
}

// Method 2: recursion
   public ListNode reverseKGroup(ListNode head, int k) {
        ListNode curr = head;
        int count = 0;
        while (curr != null && count != k) {
            curr = curr.next;
            count++;
        }
        
        if (count == k) { // if k+1 node is found
            curr = reverseKGroup(curr, k); // reverse list with k+1 node as head
            while (count-- > 0) {  
                ListNode tmp = head.next; 
                head.next = curr;  
                curr = head; 
                head = tmp; 
            }
            head = curr;//不能直接return curr，例如Input [1],2, 直接返回curr就是null
        }
        return head;
    }


// Method 3: 模板
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode end=dummy;
        int count = 0;
        while(end!=null && count++<k){
            end = end.next;
        }
        if(end==null) return dummy.next;
        
        ListNode nexthead = reverseKGroup(end.next, k);
        end.next = nexthead;
        
        
        ListNode start = dummy.next, then = start.next;
        while(dummy.next!=end){
            start.next = then.next;
            then.next = dummy.next;
            dummy.next = then;
            then = start.next;
        }
        
        return dummy.next;
    }
