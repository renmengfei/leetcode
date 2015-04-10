// Method 1:  O(N^2) time, O(N) space 投影到x轴，按照largest rectangle in histogram做
public class Solution {
  	public int maximalRectangle(char[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0)
			return 0;
		int cols = matrix[0].length; // column length
		int rows = matrix.length; // row length
		int max = 0;

		int[] height = new int[cols];

		for (int row = 0; row < rows; row++) {
			for (int i = 0; i < cols; i++) {
				if (matrix[row][i] == '1')
					height[i] += 1;
				else
					height[i] = 0;
			}
			max = Math.max(max, largestRectangleArea(height));
		}// end for
		return max;
	}

	public int largestRectangleArea(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int[] newheight = new int[height.length + 1];
		System.arraycopy(height, 0, newheight, 0, height.length);
		newheight[height.length] = 0;

		Stack<Integer> s = new Stack<>();
		int i = 0;
		int maxarea = 0;

		while (i < newheight.length) {
			if (s.isEmpty() || newheight[i] >= newheight[s.peek()]) {
				s.push(i++);
			} else {
				int index = s.pop();
				maxarea = Math.max(maxarea, newheight[index] * (s.isEmpty() ? i : (i - s.peek() - 1)));
			}
		}
		return maxarea;
	}
}

// Method 2, brute force, O(N^3),
	public int maximalRectangle(char[][] matrix) {
		// IMPORTANT: Please reset any member data you declared, as
		// the same Solution instance will be reused for each test case.
		int m = matrix.length;
		int n = m == 0 ? 0 : matrix[0].length;
		int maxArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					int tmp = maxRectangle(matrix, i, j);
					maxArea = Math.max(maxArea, tmp);
				}
			}
		}

		return maxArea;
	}

	public int maxRectangle(char[][] matrix, int row, int col) {
		int minWidth = Integer.MAX_VALUE;
		int maxArea = 0;
		for (int i = row; i < matrix.length && matrix[i][col] == '1'; i++) {
			int width = 0;
			while (col + width < matrix[0].length && matrix[i][col + width] == '1') {
				width++;
			}

			minWidth = Math.min(minWidth, width);
			int area = minWidth * (i - row + 1);
			maxArea = Math.max(maxArea, area);
		}
		return maxArea;
	}

