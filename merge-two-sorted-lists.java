// Method 1: Iterative
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
       ListNode dummy = new ListNode(0);
       ListNode tail = dummy;
       
       while(l1!=null && l2!=null){
           if(l1.val<l2.val){
               tail.next = l1;
               l1=l1.next;
           }
           else{
               tail.next=l2;
               l2=l2.next;
           }
           tail=tail.next;
       }
       if(l1!=null)tail.next = l1;
       else tail.next=l2;
       return dummy.next;
    }
}


// Method 2: recursive 最好不用，占用heap
public class Solution {
    //Recursively
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // IMPORTANT: Please reset any member data you declared, as
        // the same Solution instance will be reused for each test case.

        if(l1==null) return l2;
        if(l2==null) return l1;
        ListNode head = null;

        if(l1.val<l2.val){
            head = new ListNode(l1.val);
            head.next = mergeTwoLists(l1.next, l2);
        }
        else{
            head = new ListNode(l2.val);
            head.next=mergeTwoLists(l1,l2.next);
        }
        return head;
    }
}
