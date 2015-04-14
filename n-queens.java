public class Solution {
    public List<String[]> solveNQueens(int n) {
        List<String[]> result = new ArrayList<String[]>();
        dfs(result,  n, 0, new int[n]);
        return result;
    }
    
    public void dfs(List<String[]> result, int n, int row, int[] path){
        if(row==n){
            result.add(ToString(path));
            return;
        }
        for(int i=0;i<n;i++){
            path[row]=i;
            if(canPlace(path,row, i)){
                dfs(result, n, row+1, path);
            }
        }
    }
    
    public String[] ToString(int[] path){
        int n = place.length;
        String[] result = new String[n];

        for(int row=0;row<n;row++){
            int col = place[row];
            String s = "";
            for(int i=0;i<n;i++){
                if(i==col) s+="Q";
                else s+=".";
            }
            result[row]=s;
        }
        return result;
    }
    
    public boolean canPlace(int [] path, int row, int col){
        for(int i=0;i<row;i++){
            if(path[i]==col || Math.abs(row-i)==Math.abs(path[i]-col)) return false;
        }
        return true;
    }
}
