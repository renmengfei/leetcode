public class Solution {
 	public boolean exist(char[][] board, String word) {
		for (int y = 0; y < board.length; y++) {
			for (int x = 0; x < board[y].length; x++) {
				if (exist(board, y, x, word))
					return true;
			}
		}
		return false;
	}

	private boolean exist(char[][] board, int row, int col, String word) {
		if (word.isEmpty())
			return true;
		if (row < 0 || col < 0 || row == board.length || col == board[row].length)
			return false;
		if (board[row][col] != word.charAt(0))
			return false;
		board[row][col] ^= 256;
		boolean exist = exist(board, row, col + 1, word.substring(1)) || exist(board, row, col - 1, word.substring(1)) || exist(board, row + 1, col, word.substring(1))
				|| exist(board, row - 1, col, word.substring(1));
		board[row][col] ^= 256;
		return exist;
	}

}
