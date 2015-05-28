// merge sort
//唯一的bug：findmiddle，fast不能等于head，而是要等于head.next
// [2,1],否则middle等于1，right＝null，left死循环
public class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
            
        // find middle
        ListNode middle = findMiddle(head);
        ListNode sortedRight = sortList(middle.next);
        middle.next=null;
        ListNode sortedLeft = sortList(head);
        return merge(sortedLeft, sortedRight);
    }
    
    public ListNode findMiddle(ListNode node){
        ListNode slow = node;
        ListNode fast = node.next;
        while(fast!=null && fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
    
    public ListNode merge(ListNode head1, ListNode head2){
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while(head1 != null && head2 != null){
            if(head1.val<head2.val){
                cur.next = head1;
                head1 = head1.next;
            }
            else{
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }
        
        if(head1!=null){
            cur.next = head1;
        }
        else{
            cur.next = head2;
        }
        return dummy.next;
        
    }
}
