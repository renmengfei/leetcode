public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return add(l1,l2,0);
        
    }
    public ListNode add(ListNode l1, ListNode l2, int carry){
        if(l1==null) return single(l2,carry);
        if(l2==null) return single(l1,carry);
        
        int sum = l1.val+l2.val+carry;
        ListNode head = new ListNode(sum%10);
        head.next = add(l1.next, l2.next, sum/10);
        return head;
           
    }
    
    public ListNode single(ListNode l, int carry){
        if(carry==0) return l;
        if(carry!=0 && l==null) return new ListNode(carry);
        
        int sum = l.val+carry;
        if(sum<10){
            l.val=sum;
            return l;
        }
        
        l.val = sum%10;
        l.next = single(l.next, sum/10);
        return l;
    }
}
