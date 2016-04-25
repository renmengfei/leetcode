public class Solution {
    public boolean isSelfCrossing(int[] x) {
        if(x==null || x.length<3) return false;
        
        for(int i=3;i<x.length;i++){
            //case 1:
            // ┌───┐
            // │   │
            // └───┼>
            if( x[i]>=x[i-2] &&x[i-3]>=x[i-1]) return true;
            //case 2:重合
            // ┌───┐
            // │   │
            // └───┼
            if(i>3) {
                if(x[i-1]==x[i-3] && x[i-2]<=x[i]+x[i-4]) return true;
            }
            //case 3:
            // ┌───┐
            // |   |    
            // |  <+---┐   
            // │   │   |
            // └───┼----
            if(i>4){
             if(x[i-4]+x[i]>=x[i-2] && x[i-5]+x[i-1]>=x[i-3] && x[i-3]>=x[i-1] && x[i-2]>=x[i-4]) return true;
            }
        }
        return false;
    }
}
