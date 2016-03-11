// 使用adjacency list
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegrees = new int[numCourses];
        List<List<Integer>> adjs = new ArrayList<>();
        for(int i=0;i<numCourses; i++){
            adjs.add(new ArrayList<Integer>());
        }
        
        initialiseGraph(indegrees, adjs, prerequisites);
        return BFS(indegrees, adjs);
    }
    
    public void initialiseGraph(int[] indegrees, List<List<Integer>> adjs, int[][] prerequisites){
        for(int i=0; i<prerequisites.length;i++){
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            
            //TODO:判断duplicates
            indegrees[end]++;
            adjs.get(start).add(end);
        }
    }
    
    public int[] BFS(int[] indegrees, List<List<Integer>> adjs){
        int[] order = new int[indegrees.length];
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < indegrees.length; i++) {
            if (indegrees[i] == 0) q.offer(i);
        }
        
        int count = 0;
        while(!q.isEmpty()){
            int course = q.poll();
            order[count++]= course;
            
            for(int i: adjs.get(course)){
                if(--indegrees[i]==0){
                    q.offer(i);
                }
            }
        }
        
        return count==indegrees.length? order: new int[0];
    }
}


// Method 2: DFS, visited, not-visited, ontrack
public class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjs = new ArrayList<>();
        for(int i=0;i<numCourses; i++){
            adjs.add(new ArrayList<Integer>());
        }
        
        initialiseGraph(adjs, prerequisites);
        return helper(adjs);
    }
    
    public void initialiseGraph(List<List<Integer>> adjs, int[][] prerequisites){
        for(int i=0; i<prerequisites.length;i++){
            int end = prerequisites[i][0];
            int start = prerequisites[i][1];
            adjs.get(start).add(end);
        }
    }
    
    public int[] helper(List<List<Integer>> adjs){
        int[] visited = new int[adjs.size()];// 0=not visited; 1=visited; -1: ontrack
        Stack<Integer> s = new Stack<Integer>();//后进先出
        
        for(int i=0; i<adjs.size(); i++){
            if(visited[i]==0){
                if(!dfs(i, adjs, visited, s)) return new int[0];
            }
        }
        
        int[] res = new int[adjs.size()];
        for(int i=0;i<adjs.size();i++){
            res[i]=s.pop();
        }
        
        return res;
    }
    
    public boolean dfs(int course, List<List<Integer>> adjs, int [] visited, Stack<Integer> s){
       visited[course] = -1;
       for(int to: adjs.get(course)){
           if(visited[to]==-1) return false;
           if(visited[to]==0 && !dfs(to, adjs, visited, s)) return false;
       }
       visited[course]=1;
       s.push(course);
       return true;
       
    }
}
