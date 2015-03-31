class MinStack {
    Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> mindata= new Stack<Integer>();
	public void push(int x) {
		if(mindata.isEmpty()){
			data.push(x);
			mindata.push(x);
		}
		else{
			data.push(x);
			//bug: <=等号不能少
			if(x<=mindata.peek()){
				mindata.push(x);
			}
		}
	}

	public void pop() {
		int x = data.peek();
		data.pop();
		if(mindata.peek()==x) mindata.pop();
	}

	public int top() {
		return data.peek();
	}

	public int getMin() {
		return mindata.peek();
		
	}
}

