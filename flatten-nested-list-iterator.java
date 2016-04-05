// 使用stack<Iterator> + pre-peeked element
public class NestedIterator implements Iterator<Integer> {
    Stack<Iterator<NestedInteger>> stack;
    NestedInteger current;
    
    public NestedIterator(List<NestedInteger> nestedList) {
        current = null;
        stack = new Stack<Iterator<NestedInteger>>();
        if(nestedList==null || nestedList.isEmpty()) return;
        stack.push(nestedList.iterator());
    }

    @Override
    public Integer next() {
       if (current != null) {
            Integer result = current.getInteger();
            current = null;
            return result;
        } else {
            throw new RuntimeException();
        }
        
    }

    @Override
    public boolean hasNext() {
         while (stack.size() > 0) {
            Iterator<NestedInteger> currentIterator = stack.peek();

            if (currentIterator.hasNext()) {
                NestedInteger next = currentIterator.next();
                if (next.isInteger()) {
                    current = next;
                    return true;
                } else {
                    stack.push(next.getList().iterator());
                }
            } else {
                stack.pop();
            }

        }

        return false;
    }
}


