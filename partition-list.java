// Method 1: two lists 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummyleft = new ListNode(0);
        ListNode dummyright = new ListNode(0);
        ListNode left = dummyleft, right = dummyright;
        
        ListNode ptr = head;
        
        while(ptr!=null){
            if(ptr.val<x){
                left.next = ptr;
                left = left.next;
            }
            else{
                right.next = ptr;
                right = right.next;
            }
            ptr=ptr.next;
        }
	// bug: 一定要加null，不然指针会死循环
        right.next=null;
        
        left.next = dummyright.next;
        return dummyleft.next;
        
    }
}

// Method 2: in place, hard
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy=new ListNode(0);
        dummy.next=head;
        ListNode p=dummy;
        ListNode tail = dummy;
        
        while(p!=null && p.next!=null){
            if(p.next.val>=x){
                p=p.next;
            }
            else{
		// bug : p==tail
                if(p==tail){
                    p=p.next;
                    tail=tail.next;
                }
                else{
                    ListNode tmp = p.next;
                    p.next = tmp.next;
                    tmp.next = tail.next;
                    tail.next=tmp;
                    tail = tmp;
                    
                }
            }
        }
       return dummy.next;
        
    }
}

