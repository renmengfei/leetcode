// union-find
// Method 1: qick union
public class Solution {
    int[] id;
    public int countComponents(int n, int[][] edges) {
        id = new int[n];
        
        for(int i=0;i<n;i++){
            id[i] = i;
        }
        
        for (int i = 0; i < edges.length; i++) {
             union(edges[i][0], edges[i][1]);
        }
        
        Set<Integer> set = new HashSet<Integer>();
        
        for(int i=0; i<n; i++){
            set.add(find(i));
        }
        
        return set.size();
    }
    
    public void union(int i, int j){
        int root1 = find(i);
        int root2 = find(j);
        id[root1]=root2;
    }
    
    public int find(int i){
        int root = i;
        while(root!=id[root]){
            root = id[root];
        }
        return root;
    }

}

// Method 2: quick find
  public void union(int p, int q){
        int label = id[p];
        for(int i=0; i<id.length; i++){
            if(id[i]==label){
                id[i] = id[q];
            }
        }
    }
    
