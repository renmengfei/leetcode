class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;
    
    public MyQueue(){
        s1 = new Stack<Integer>();
        s2 = new Stack<Integer>();
    }
    // Push element x to the back of queue.
    public void push(int x) {
        s1.add(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        peek();
        s2.pop();
    }

    // Get the front element.
    public int peek() {
        if(s2.isEmpty()){
            while(!s1.isEmpty()){
                s2.add(s1.pop());
            }
        }
        return s2.peek();
    }
    

    // Return whether the queue is empty.
    public boolean empty() {
        return s1.isEmpty()&&s2.isEmpty();
    }
}
