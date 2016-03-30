public class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    
    public int helper(List<NestedInteger> nestedList, int level){
        if(nestedList==null || nestedList.isEmpty()) return 0;
        
        int sum = 0;
        
        for(NestedInteger n: nestedList){
            if(n.isInteger()){
                sum+=n.getInteger()*level;
            }
            else{
                sum+=helper(n.getList(), level+1);
            }
        }
        return sum;
    }
}
