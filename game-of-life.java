// board[i][j]只用1bit存储0,1.现在用第2bit存储new status
// 1 -> count<2   ->0
//   -> count=2|3 ->1
//   -> count>3   ->0

// 0 -> count==3  ->1
//   -> else      ->0

//计算九宫格的count，只有0的count=3， 1的count=2|3的时候，|=2
//其他情况，都变成0，不用改变board[i][j]的值
public class Solution {
    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        
        for(int i=0;i<m; i++){
            for(int j=0;j<n;j++){
                int count = 0;
                for(int a=Math.max(0, i-1); a<Math.min(i+2, m); a++){
                    for(int b=Math.max(0, j-1); b<Math.min(j+2, n); b++){
                        count += board[a][b]&1;
                    }
                }
                if(count==3 || count-board[i][j]==3){
                    board[i][j] |= 2;
                }
            }
        }
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                board[i][j] >>=1;
            }
        }
    }
}
