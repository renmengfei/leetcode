//不是typological sort，因为可能有cycle
//这道题是一笔画问题
// greedy DFS,一条路走到底，走不动了，再pop

public class Solution {
    public List<String> findItinerary(String[][] tickets) {
        List<String> result = new ArrayList<String>();
        if(tickets == null || tickets.length ==0) return result;
        
        Map<String, PriorityQueue<String>> map = new HashMap<>();
        for(String[] ticket: tickets){
            if(!map.containsKey(ticket[0])) map.put(ticket[0], new PriorityQueue<String>());
            map.get(ticket[0]).add(ticket[1]);
        }
        
        Stack<String> s = new Stack<String>();
        s.push("JFK");
        
        while(!s.isEmpty()){
            String cur = s.peek();
            if(map.containsKey(cur) && !map.get(cur).isEmpty()){
                s.push(map.get(s.peek()).poll());
            }
            else{
                result.add(0,cur);
                s.pop();
            }
        }
        
        return result;
    }
}
