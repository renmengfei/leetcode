// words是字典顺序，而不是每个letter的顺序
// about
// book
// zoo, 不代表z在o前面~~，而是words按顺序排列，竖着比~~


public class Solution {
    public String alienOrder(String[] words) {
        Map<Character, Set<Character>> order = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();
        
        //(1) find unique letters
        for(String word: words){
            for(char c: word.toCharArray()){
                indegree.put(c, 0);
            }
        }
        
        // (2) find order，相邻两个就够了，不需要全部比较一遍
        for(int i=0;i<words.length-1; i++){
            String cur = words[i];
            String next = words[i+1];
            
            int commonLen = Math.min(cur.length(), next.length());
            for(int j=0;j<commonLen; j++){
                char c1 = cur.charAt(j);
                char c2 = next.charAt(j);
                
                if(c1!=c2){
                    if(!order.containsKey(c1)){
                        order.put(c1, new HashSet<Character>());
                    }
                    if(!order.get(c1).contains(c2)){
                        order.get(c1).add(c2);
                        indegree.put(c2, indegree.get(c2)+1);
                    }
                    break;
                }
            }
        }
        
        // BFS topological sort
        String result = "";
        Queue<Character> q = new LinkedList<Character>();
        for(char c: indegree.keySet()){
            if(indegree.get(c)==0){
                q.offer(c);
            }
        }
        
        
        while(!q.isEmpty()){
            char c = q.poll();
            result+=c;
            
            if(order.containsKey(c)){
                for(char c2: order.get(c)){
                    indegree.put(c2, indegree.get(c2)-1);
                    if(indegree.get(c2)==0) q.offer(c2);
                }
            }
        }
        
        if(result.length()!=indegree.size()) return "";
        return result;
        
        
    }
}

