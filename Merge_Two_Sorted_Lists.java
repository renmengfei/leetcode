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
