// Method 1: DFS, recursively
public class Solution {
    static int[] dx = {-1,0,0,1};
    static int[] dy = {0,1,-1,0};
    public static int numIslands(char[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int islands = 0;
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[i].length;j++) {
                if(grid[i][j]=='1') {
                    explore(grid,i,j);
                    islands++;
                }
            }
        }
        return islands;
    }
    public static void explore(char[][] grid, int i, int j) {
        grid[i][j]='x';
        for(int d=0;d<dx.length;d++) {
            if(i+dy[d]<grid.length && i+dy[d]>=0 && j+dx[d]<grid[0].length && j+dx[d]>=0 && grid[i+dy[d]][j+dx[d]]=='1') {
                explore(grid,i+dy[d],j+dx[d]);
            }
        }
    }
}


// Method 2: BFS, Similar to Surrounded-Region
public class Solution {
    public class Pair{
        public int x;
        public int y;
        public Pair(int x1, int y1){
            x=x1;
            y=y1;
        }
    }
    
    int result = 0;
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        if(rows==0) return result;
        
        int cols = grid[0].length;
        
        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(grid[i][j]=='1'){
                    bfs(grid, i, j);
                }
            }
        }
        return result;
    }
    
    public void bfs(char[][] grid, int row, int col){
        Queue<Pair> q = new LinkedList<Pair>();
        q.add(new Pair(row,col));
        grid[row][col] = '2';
        while(!q.isEmpty()){
            Pair cur = q.poll();
            Pair[] adjs = {new Pair(cur.x-1, cur.y), new Pair(cur.x+1,cur.y), new Pair(cur.x, cur.y-1), new Pair(cur.x,cur.y+1)};
            for(int i=0;i<4;i++){
                int x1 = adjs[i].x;
                int y1 = adjs[i].y;
                if(x1>=0 && x1<grid.length && y1>=0 && y1<grid[0].length && grid[x1][y1]=='1'){
                    grid[x1][y1]='2';
                    q.add(new Pair(x1,y1));
                }
            }
        }
        result++;
    }
}




