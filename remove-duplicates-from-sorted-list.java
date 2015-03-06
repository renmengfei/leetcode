//O(N)
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null) return null;
        ListNode pivot = head;
        ListNode cur = pivot.next;
        
        while(cur!=null){
            // pay attention to &&, always use && instead of &.
            // cur!=null is important
            while(cur!=null && cur.val==pivot.val) cur= cur.next;
            if(cur==null) {
                pivot.next=null;
                return head;;
            }
            pivot.next=cur;
            pivot = cur;
            cur=cur.next;
        }
        return head;
    }
}
