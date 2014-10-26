// BackTracking
public class Solution {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if(n<=0) return result;
        gen(n,n,"",result);
        return result;
    }
    
    public void gen(int left, int right, String solution, List<String> result){
        if(left>right) return;
        if(left==0 && right==0){
            result.add(solution);
            return;
        }
        if(left>0){
            gen(left-1,right,solution+"(",result);
        }
        if(right>0){
            gen(left,right-1,solution+")",result);
        }
    }
}
