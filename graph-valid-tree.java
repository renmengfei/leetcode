// union后所有id一样，每次union前先判断cycle
public class Solution {
    int[] id;
    public boolean validTree(int n, int[][] edges) {
        id = new int[n];
        for(int i=0;i<n;i++){
            id[i]=i;
        }
        
        for(int i=0; i<edges.length; i++){
            boolean no_cycle = union(edges[i][0], edges[i][1]);
            if(!no_cycle) return false;
        }
        
        int pivot = id[0];
        for(int i=1;i<n;i++){
            if(id[i]!=pivot) return false;
        }
        return true;
    }
    
    public boolean union(int p, int q) {
        if(id[p]==id[q]) return false;
        int tmp = id[p];
        for(int i=0;i<id.length; i++){
            if(id[i]==tmp)
                id[i] = id[q];
        }
        
        return true;
    }
}
