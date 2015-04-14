public class Solution {
    public ListNode insertionSortList(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode cur = head;
        
        ListNode ptr = null;
        while(cur!=null){
            ptr = dummy;
            while(ptr.next!=null && ptr.next.val<cur.val){
                ptr=ptr.next;
            }
            ListNode next = cur.next;
            cur.next = ptr.next;
            ptr.next = cur;
            cur= next;
        }
        
        return dummy.next;
    }
}
