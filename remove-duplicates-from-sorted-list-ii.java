public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pivot = dummy;
        ListNode p1= head, p2=head.next;
        
        while(p2!=null){
            if(p2.val!=p1.val){
                pivot = p1;
                p1=p2;
                p2 = p2.next;
            }
            else{
                while(p2!=null && p2.val==p1.val){
                    p2 = p2.next;
                }
                if(p2==null) {
                    pivot.next = null;
                    return dummy.next;
                }
                pivot.next=p2;
                p1 = p2;
                p2 = p2.next;
            }
        }
        return dummy.next;
    }
}
