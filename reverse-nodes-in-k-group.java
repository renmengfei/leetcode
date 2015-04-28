// Method 1: iteration
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null || head.next==null || k<2) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode start = dummy; // before the real start
        ListNode end = dummy; //the real end
        ListNode pivot = head; //记录reverse后的末尾，也就是reverse的开头
        while(end!=null){
            int count = 0;
            while(end!=null && count<k){
                end = end.next;
                count++;
            }
            if(end==null) return dummy.next;
	    // bug: pivot要留着，记录末尾
            pivot = start.next;
            
            ListNode tmp;
            while(start.next!=end){
                tmp = start.next;
                start.next = tmp.next;
                tmp.next = end.next;
                end.next = tmp;
            }
            start = pivot;
            end = pivot;
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

