// O(N) time, O(1) space
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null) return null;
        int l1=getLength(headA);
        int l2 = getLength(headB);
        
        ListNode ptr1 = headA;
        ListNode ptr2 = headB;
        
        if(l1>l2){
            while(l1>l2){
                ptr1=ptr1.next;
                l1--;
            }    
        }
        
        if(l2>l1){
            while(l2>l1){
                ptr2=ptr2.next;
                l2--;
            }
        }
        
        while(ptr1!=null && ptr2!=null && ptr1!=ptr2){
            ptr1=ptr1.next;
            ptr2=ptr2.next;
        }
        return ptr1;
    }
    
    public int getLength(ListNode node){
        int n = 0;
        while(node!=null){
            node = node.next;
            n++;
        }
        return n;
    }
}
