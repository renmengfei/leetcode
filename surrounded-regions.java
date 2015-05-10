// Method 1: O(N^2) time
//Use BFS starting from 'O's on the boundary and mark them as 'B', then iterate over the whole board and mark 'O' as 'X' and 'B' as 'O'.
public class Solution {
    public class Pair{
        public int x;
        public int y;
        public Pair(int x1, int y1){
            x=x1;
            y=y1;
        }
    }
    public void solve(char[][] board) {
        int rows = board.length;
        if(rows==0) return;
        int cols = board[0].length;
        if(cols==0) return;
        
        // top, bottom boundary
        for(int i=0;i<cols;i++){
            if(board[0][i]=='O'){
                bfs(board, 0, i);
            }
            if(board[rows-1][i]=='O'){
                bfs(board, rows-1,i);
            }
        }
        
        // left, right boundary
        for(int i=0;i<rows;i++){
            if(board[i][0]=='O'){
                bfs(board,i,0);
            }
            if(board[i][cols-1]=='O'){
                bfs(board,i,cols-1);
            }
        }
        
        // scan again
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(board[i][j]=='O') board[i][j]='X';
                else if(board[i][j]=='B') board[i][j]='O';
            }
        }
    }
    
    public void bfs(char[][] board, int row, int col){
        int rows = board.length;
        int cols = board[0].length;
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row,col));
	// bug:必须先改value，不能在while里面poll后再改
        board[row][col] = 'B';
        while (!q.isEmpty()) {
            Pair cur = q.poll();
            Pair[] adjs = {new Pair(cur.x-1, cur.y), new Pair(cur.x+1,cur.y), new Pair(cur.x, cur.y-1), new Pair(cur.x,cur.y+1)};
            for (int i = 0; i < 4; ++i){
                int x1 = adjs[i].x;
                int y1 = adjs[i].y;
                if ((x1 >= 0) && (x1 < rows) && (y1 >= 0)
                        && (y1 < cols) 
                        && (board[x1][y1] == 'O')) {
                    q.add(new Pair(x1, y1));
                    board[x1][y1] = 'B';
                }
            }
        }
    }
}


// Method 2: union find
int[] unionSet; // union find set
boolean[] hasEdgeO; // whether an union has an 'O' which is on the edge of
					// the matrix

public void solve(char[][] board) {
	if (board.length == 0 || board[0].length == 0)
		return;

	// init, every char itself is an union
	int height = board.length, width = board[0].length;
	unionSet = new int[height * width];
	hasEdgeO = new boolean[unionSet.length];
	for (int i = 0; i < unionSet.length; i++)
		unionSet[i] = i;
	for (int i = 0; i < hasEdgeO.length; i++) {
		int x = i / width, y = i % width;
		hasEdgeO[i] = (board[x][y] == 'O' && (x == 0 || x == height - 1 || y == 0 || y == width - 1));
	}

	// iterate the matrix, for each char, union it + its upper char + its
	// right char if they equals to each other
	for (int i = 0; i < unionSet.length; i++) {
		int x = i / width, y = i % width, up = x - 1, right = y + 1;
		if (up >= 0 && board[x][y] == board[up][y])
			union(i, i - width);
		if (right < width && board[x][y] == board[x][right])
			union(i, i + 1);
	}

	// for each char in the matrix, if it is an 'O' and its union doesn't
	// has an 'edge O', the whole union should be setted as 'X'
	for (int i = 0; i < unionSet.length; i++) {
		int x = i / width, y = i % width;
		if (board[x][y] == 'O' && !hasEdgeO[findSet(i)])
			board[x][y] = 'X';
	}
}

private void union(int x, int y) {
	int rootX = findSet(x);
	int rootY = findSet(y);
	// if there is an union has an 'edge O',the union after merge should be
	// marked too
	boolean hasEdgeO = this.hasEdgeO[rootX] || this.hasEdgeO[rootY];
	unionSet[rootX] = rootY;
	this.hasEdgeO[rootY] = hasEdgeO;
}
