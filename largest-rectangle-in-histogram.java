// O(N) time
//精简版，主要思想就是，对每一个点，找它左右的临界
// stack存下标:
// 变形 maxtree, 找左右两边比这个点大的临界
public class Solution {
    public static int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int curt = (i == height.length) ? -1 : height[i];
            while (!stack.isEmpty() && curt <= height[stack.peek()]) {
                int h = height[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, h * w);
            }
            stack.push(i);
        }
        
        return max;
    }
}


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
