// 如果存k和b  y=kx+b,k可以取无穷大， 会overflow
//所以取delta y/delta x, 还要约分，约分用gcd做
// corner case: duplicate的情况，点重合了
// O(N^2)
public class Solution {
    public int maxPoints(Point[] points) {
         if (points==null) return 0;
         if (points.length<=2) return points.length;
         
         Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
         
         int result = 0;
         for(int i=0;i<points.length; i++){
             map.clear();
             int overlap=0;
             int max = 0;
             
             for(int j=i+1;j<points.length;j++){
                 int x = points[j].x-points[i].x;
                 int y = points[j].y-points[i].y;
                 
                 if(x==0 && y==0) {
                     overlap++;
                     continue;
                 }
                 
                 int gcd = getGCD(x,y);
                 x/=gcd;
                 y/=gcd;
                 
                 if(map.containsKey(x)){
                     if(!map.get(x).containsKey(y)){
                         map.get(x).put(y,0);
                     }
                     map.get(x).put(y, map.get(x).get(y)+1);
                 }
                 else{
                     Map<Integer, Integer> tmp = new HashMap<>();
                     tmp.put(y, 1);
                     map.put(x, tmp);
                 }
                 
                 max = Math.max(max, map.get(x).get(y));
             }
             
             result = Math.max(result, max+overlap+1);
         }
         return result;
            
    }
   
    // gcd算法去mod，反过来，为了使第一个param大 
    public int getGCD(int x, int y){
        if(x==0 || y==0) return x+y;
        return getGCD(y,x%y);
    }
}
