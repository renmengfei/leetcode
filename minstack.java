//Method 2: 1个stack
// if gap>=0存的是current value和min的差值
//if gap<0, current value就是min，存的是与第二小的数的gap
class MinStack {
    long min;
    Stack<Long> stack;

    public MinStack(){
        stack=new Stack<>();
    }

    public void push(int x) {
        if (stack.isEmpty()){
            stack.push(0L);
            min=x;
        }else{
            stack.push(x-min);//Could be negative if min value needs to change
            if (x<min) min=x;
        }
    }

    public void pop() {
        if (stack.isEmpty()) return;

        long pop=stack.pop();

        if (pop<0)  min=min-pop;//If negative, increase the min value

    }

    public int top() {
        long top=stack.peek();
        if (top>0){
            return (int)(top+min);
        }else{
           return (int)(min);
        }
    }

    public int getMin() {
        return (int)min;
    }
}

// Method 1: 两个stack，比较好想
class MinStack {
    Stack<Integer> data = new Stack<Integer>();
	Stack<Integer> mindata= new Stack<Integer>();
	public void push(int x) {
		// <=等号不能少
		if(mindata.isEmpty() || x<=mindata.peek()){
			mindata.push(x);
		}
		data.push(x);
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

