// O(n) space
 public int minimumTotal(List<List<Integer>> triangle) {
        int size = triangle.size();
        int[] dp = new int[size];
        // initial bottom-up
        for(int i=0;i<size;i++){
            dp[i]=triangle.get(size-1).get(i);
        }
        for(int i=size-2;i>=0;i--){
            List<Integer> cur = triangle.get(i);
            for(int j=0;j<cur.size();j++){
                dp[j]=cur.get(j)+Math.min(dp[j],dp[j+1]);
            }
        }
        return dp[0];
    }

// O(1) space, O(N) time 但不一定要求in place
public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        
        for(int i = triangle.size()-2;i>=0;i--){
            for(int j=0;j<=i;j++){
                triangle.get(i).set(j, triangle.get(i).get(j) + Math.min(triangle.get(i+1).get(j), triangle.get(i+1).get(j+1)));
            }
        }
        return triangle.get(0).get(0);
    }
}
