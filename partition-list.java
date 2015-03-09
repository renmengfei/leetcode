// Method 1: two lists 
public class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode small = new ListNode(-1), large = new ListNode(x);
        ListNode smallend=small, largeend=large;
        ListNode ptr = head;
        while(ptr!=null){
            ListNode next  = ptr.next;
            if(ptr.val<x){
                smallend.next = ptr;
                smallend = smallend.next;
            }
            else{
                largeend.next = ptr;
                largeend = largeend.next;
                largeend.next = null;//bug, 不加的话，指针会出问题
            }
            ptr = next;
        }

        smallend.next = large.next;
        return small.next;
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

