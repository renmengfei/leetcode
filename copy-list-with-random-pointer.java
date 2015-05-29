/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) return head;
        RandomListNode cur = head;
        // step 1: copy and insert
        while(cur!=null){
            RandomListNode copy = new RandomListNode(cur.label);
            copy.next = cur.next;
            cur.next = copy;
            cur = copy.next;
        }      
        
        // step 2: add random pointer
        cur = head;
        while(cur!=null){
            if(cur.random!=null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }
        
        // step 3: split old/new lists
        RandomListNode newhead = head.next;
        RandomListNode oldhead = head;
        cur = newhead;
        
        while(oldhead!=null){
            oldhead.next=oldhead.next.next;
            // bug: newlist' next = oldhead.next could be null, 例子[1,#]
            if(oldhead.next!=null){
                cur.next = cur.next.next;
            }
            cur = cur.next;
            oldhead = oldhead.next;
        }
        return newhead;
    }
}
