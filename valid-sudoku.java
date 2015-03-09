// Method 1: O(n^2) time, O(n^2) space
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] row = new boolean[9][9];
        boolean[][] col = new boolean[9][9];
        boolean[][] block = new boolean[9][9];
        
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j]!='.'){
                    int value = board[i][j]-'1';
                    if(row[i][value] || col[j][value]|| block[(i/3)*3+j/3][value]) return false;
                    else{
                        row[i][value]=true;
                        col[j][value]=true;
                        block[(i/3)*3+j/3][value]=true;
                    }
                }
            }
        }
        return true;
    }
}

// Method 2: hashset. O(1) space, O(N^2) time
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int i=0;i<9;i++){
            //check rows
            if(!partialValid(board,i,0,i,8)) return false;
            //check cols
            if(!partialValid(board,0,i,8,i)) return false;
        }
        
        //check blocks
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (!partialValid(board,i*3,j*3,i*3+2,j*3+2)) return false;
            }
        }
        return true;
    }
    
    public boolean partialValid(char[][] board, int x1, int y1, int x2, int y2){
        HashSet<Character> set = new HashSet<Character>(); 
        for(int i=x1;i<=x2;i++){
            for(int j=y1;j<=y2;j++){
                char c = board[i][j];
                if(c!='.'){
                    if(set.contains(c)) return false;
                    set.add(c);
                }
            }
        }
        return true;
    }
}
