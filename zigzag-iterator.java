// 使用queue，适用于k vectors，充分利用java的iterator特性
public class ZigzagIterator {
    Queue<Iterator> q  =  new LinkedList<Iterator>();;
    
    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        if(v1!=null && v1.size()!=0) q.add(v1.iterator());
        if(v2!=null && v2.size()!=0) q.add(v2.iterator());
    }

    public int next() {
        Iterator cur = q.poll();
        int result = (Integer)cur.next();
        if(cur.hasNext()) q.add(cur);
        return result;
    }

    public boolean hasNext() {
        return !q.isEmpty();
    }
}
