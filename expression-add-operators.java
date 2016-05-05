// (1) overflow所以要用long来存每一步结果
// (2) 0不能作为开头，除非是一个单独的0
// (3) 乘法很特殊，a+b*c, 前一步是a+b, 现在要做a-b+b*c, backtracking
public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> rst = new ArrayList<String>();
        if(num == null || num.length() == 0) return rst;
        helper(rst, "", num, target, 0, 0, 0);
        return rst;
    }
    
    public void helper(List<String> rst, String path, String num, int target, int pos, long eval, long multed){
         if(pos == num.length()){
            if(target == eval)
                rst.add(path);
            return;
        }
        
        for(int i = pos; i < num.length(); i++){
            if(num.charAt(pos)=='0' && i!=pos) break;
            long cur = Long.parseLong(num.substring(pos, i+1));
            
            if(pos==0){
                helper(rst, path+cur, num, target, i+1, cur, cur);
            }
            else{
                helper(rst, path+"+"+cur, num, target, i+1, eval+cur, cur);
                helper(rst, path+"-"+cur, num, target, i+1, eval-cur, -cur);
                helper(rst, path+"*"+cur, num, target, i+1, eval-multed+multed*cur, multed*cur);
                
            }
            
        }
        
    }
}
