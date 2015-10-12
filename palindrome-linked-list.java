//fast slow找中点， reverse一半，再比较
//难点，奇偶数，那个算中点
// instead of using if(fast!=null && fast.next!=null) 应该往后移一个。这样，中点在前一个。否则会越过中点，无法往前找
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next ==null) return true;
        
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        slow.next = reverse(slow.next);
        slow = slow.next;
        fast = head;
        while(slow!=null){
           if(fast.val!=slow.val) return false;
           fast = fast.next;
           slow = slow.next;
        }
        return true;
    }
    
    public ListNode reverse(ListNode head){
        ListNode newhead = null;
        
        while(head!=null){
            ListNode next = head.next;
            head.next = newhead;
            newhead =head;
            head = next;
        }
        return newhead;
    }
}
