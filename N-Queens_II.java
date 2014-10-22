/* Exponential increase.

O(a^N).
https://sites.google.com/site/nqueensolver/home/algorithm-results
This is a NP-complete problem
*/

//Method 1: Recursive
public class Solution {
    
    int count;//global variaable
    public int totalNQueens(int n) {
        count=0;
        if(n<=0) return count;
        dfs(new int[n],0,n);
        return count;
    }
    
    public void dfs(int[] solution, int row, int n){
        if(row==n) {
            count++;
            return;
        }
        for(int i=0;i<n;i++){
            solution[row]=i;
            if(isValid(solution, row)){
                dfs(solution,row+1,n);
            }
        }
    }
    
    public boolean isValid(int[] solution, int row){
        //if(row==0) return true; // this is not neccessary, for(i<row) is ignored and return true
        for(int i=0;i<row;i++){
            if(solution[i]==solution[row]||(row-i)==Math.abs(solution[row]-solution[i])) return false;
        }
        return true;
    }
}



//Method 2: bitmap
// problem, N<32
    int count = 0;
    public int totalNQueens(int n) {
         totalNQueens(n, 0,0,0);
         return count;
    }
    
    public void totalNQueens(int n, int col, int ld, int rd) {
        if(col==(1<<n)-1)  count++; // when all n queens are placed
        for(int i=0;i<n;++i){ // try every possible position
            int pos = 1<<i;
            if((~(col | ld | rd) & pos)>0) // pay attention to (), operation priority~(col|ld|rd)&pos>0  , wrong!!!
                totalNQueens(n, col|pos, (ld|pos)<<1, (rd|pos)>>1);
    }


//Method 3: bitmap
int count = 0;
    int upperlim = 1;
    public int totalNQueens(int n) {
         upperlim = (1<<n)-1;
         totalNQueens(0,0,0);
         return count;
    }
    
    public void totalNQueens(int col, int ld, int rd) {
        int pos, p;  
        if ( col != upperlim ) {  
            pos = upperlim & (~(col | ld | rd ));  // upperilm & 不可少！！作为位数限制！不然pos＝~(col|ld|rd)=111111超过限制
            while ( pos >0) {  
                p = pos & (~pos + 1);  
                pos = pos - p;  
                totalNQueens(col | p, (ld | p) << 1, (rd | p) >> 1);  
            }  
        }  
        else  
            count++; 
        }
    

