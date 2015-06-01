// Method 1: BFS, iteration
// 难点，注意放如q的顺序，和检查map的顺序
public class Solution {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
        
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        queue.add(node);
        map.put(node, result);
        
        while(!queue.isEmpty()){
            UndirectedGraphNode cur = queue.poll();
            for(UndirectedGraphNode n: cur.neighbors){
                if(!map.containsKey(n)){
                    map.put(n, new UndirectedGraphNode(n.label));
                    queue.add(n);
                }
                map.get(cur).neighbors.add(map.get(n));
            }
        }
        
        return result;
    }
}
    
// Method 2: DFS, recursive
public class Solution {
    HashMap<UndirectedGraphNode,UndirectedGraphNode> map = new HashMap<UndirectedGraphNode,UndirectedGraphNode>();
     
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        if(node==null) return null;
        if(map.containsKey(node)) return map.get(node);
        
        UndirectedGraphNode result = new UndirectedGraphNode(node.label);
        map.put(node, result);
        
        for(UndirectedGraphNode n: node.neighbors){
            UndirectedGraphNode newn = cloneGraph(n);
            map.get(node).neighbors.add(newn);
        }
        return result;
    }
}
