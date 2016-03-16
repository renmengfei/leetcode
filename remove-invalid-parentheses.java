// Method 1: BFS, T(n) = n x C(n, n) + (n-1) x C(n, n-1) + ... + 1 x C(n, 1) = n x 2^(n-1).
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> result = new ArrayList<>();
        if(s==null) return result;
        
        boolean found = false;
        
        Queue<String> q = new LinkedList<String>();
        //用于dedupe
        Set<String> visited = new HashSet<>();
        
        q.add(s);
        visited.add(s);
        
        while(!q.isEmpty()){
            String cur = q.poll();
            if(isValid(cur)){
                found = true;
                result.add(cur);
            }
            
            if(found) continue;
            
            for(int i=0;i<cur.length();i++){
                if(cur.charAt(i)!='(' && cur.charAt(i)!=')') continue;
                String sub = cur.substring(0,i)+cur.substring(i+1);
                if(!visited.contains(sub)){
                    q.add(sub);
                    visited.add(sub);
                }
            }
        }
        
        return result;
        
    }
    
    public boolean isValid(String s){
        int count = 0;
        
        for(char c: s.toCharArray()){
            if(c=='(') count++;
            else if(c==')' && --count<0) return false;
        }
        
        return count==0;
    }
}

// method 2: DFS
public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        int rmL = 0, rmR=0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(') rmL++;
            if(s.charAt(i)==')') {
                if(rmL>0) rmL--;
                else rmR++;
            }
        }
        Set<String> res = new HashSet<>();
        
        DFS(res, s, 0, rmL, rmR, 0, new StringBuilder());
        return new ArrayList<String>(res);
    }
    
    public void DFS(Set<String> result, String s, int level, int rmL, int rmR, int open, StringBuilder sb){
        if(level == s.length() && rmL == 0 && rmR == 0 && open == 0) {
            result.add(sb.toString());
            return;
        }
        if(level == s.length() || rmL < 0 || rmR < 0 || open < 0) return;

        
        char c = s.charAt(level);
        
        int len = sb.length();
        if(c=='('){
            DFS(result, s, level+1, rmL-1, rmR, open, sb);//delete '(''
            DFS(result, s, level+1, rmL, rmR, open+1, sb.append(c));
        }
        else if(c==')'){
            DFS(result, s, level+1, rmL, rmR-1, open, sb);
            DFS(result, s, level+1, rmL, rmR, open-1, sb.append(c));
        }
        else{
            DFS(result, s, level+1, rmL, rmR, open, sb.append(c));
        }
        sb.setLength(len);// backtracing, like remove
        
    }
}
