// Method 1: 多路归并，优先队列
// O(Nlogk)
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists==null||lists.length==0) return null;
	//实现compare方法
        PriorityQueue<ListNode> queue= new PriorityQueue<ListNode>(lists.length,new Comparator<ListNode>(){
            @Override
            public int compare(ListNode o1,ListNode o2){
                if (o1.val<o2.val)
                    return -1;
                else if (o1.val==o2.val)
                    return 0;
                else 
                    return 1;
            }
        });
        
        ListNode dummy = new ListNode(0);
        ListNode ptr=dummy;
        
        // add all lists to queue
        for(ListNode node: lists){
            if(node!=null) queue.add(node);
        }
        // pop minimum node and merge
        while (!queue.isEmpty()){
            ptr.next=queue.poll();
            ptr=ptr.next;
	    
	    // bug: check next＝null
            if (ptr.next!=null)
                queue.add(ptr.next);
        }
        return dummy.next;
    }
}

// Method 2: 原始merge，两两merge
public class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
       if(lists==null||lists.length==0){
            return null;
        }
        ArrayList<ListNode> alist =  new ArrayList<ListNode>(Arrays.asList(lists));
        while(alist.size()>1){
            ArrayList<ListNode> tmp = new ArrayList<ListNode>();
            //如果是奇数，先把最后一个放入tmp，然后其他偶数合并 
            if(alist.size()%2!=0){
                tmp.add(alist.get(alist.size()-1));
            }
            for(int i=0;i<alist.size()/2;i++){
                tmp.add(mergeTwo(alist.get(2*i), alist.get(2*i+1)));
            }

            alist = new ArrayList<ListNode>(tmp);
        }
        return alist.get(0);
    }
    
    // merge two lists
    public ListNode mergeTwo(ListNode l1, ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;

        ListNode head;
        if(l1.val < l2.val){
            head = new ListNode(l1.val);
            head.next = mergeTwo(l1.next, l2);
        }
        else{
            head = new ListNode(l2.val);
            head.next = mergeTwo(l1, l2.next);
        }
        return head;
    }
}
