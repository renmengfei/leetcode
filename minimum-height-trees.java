// (1) 最多有2个root
// (2) 不停的减去叶子
// http://algobox.org/minimum-height-trees/
public class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<Integer> result = new ArrayList<Integer>();
        
        if(n==1){
            result.add(0);
            return result;
        }
        
        // Build Graph
        List<Set<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n; i++){
            adj.add(new HashSet<>());
        }
        
        for(int[] edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        
        // BFS
        List<Integer> leaves = new ArrayList<Integer>();
        for(int i=0; i<n; i++){
            if(adj.get(i).size()==1){
                leaves.add(i);
            }
        }
        
        while(n>2){
            n-=leaves.size();
            List<Integer> nextlevel = new ArrayList<>();
            for(int i: leaves){
                for(int j: adj.get(i)){
                    adj.get(j).remove(i);
                    if(adj.get(j).size()==1){
                        nextlevel.add(j);
                    }
                }
            }
            leaves = nextlevel;
        }
        return leaves;
    }
}
