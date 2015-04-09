// O(N) time
public int largestRectangleArea(int[] height) {
	if (height == null || height.length == 0)
		return 0;
	Stack<Integer> h = new Stack<Integer>();
        // bug1: newheight+1; case [1,1]
	int[] newheight = new int[height.length + 1];
	System.arraycopy(height, 0, newheight, 0, height.length);
	newheight[height.length] = 0;

	int i = 0;
	int area = 0;

	while (i < newheight.length) {
		if (h.isEmpty() || newheight[i] >= newheight[h.peek()]) {
			h.push(i++);
		} else {
			int index = h.pop();
			// i是右值，h.peek()是左值，所以height＊（right-left-1）
			area = Math.max(area, newheight[index] * (h.isEmpty() ? i : (i - h.peek() - 1)));
		}
	}
	return area;

}
