
public class Solution {
    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new ArrayList<>();
        List<int[]> height = new ArrayList<>();
        
        // step 1: 用正负区分start和end
        for(int[] build: buildings){
             height.add(new int[]{build[0], -build[2]});
             height.add(new int[]{build[1], build[2]});
        }
        //step 2: start， end打乱全排序
         Collections.sort(height, (a, b) -> {
            if(a[0] != b[0]) 
                return a[0] - b[0];
            return a[1] - b[1];
        });
        
        // step 3: max heap
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> (b - a));
        //q里首先放一个0，为了比较最后一个
        q.add(0);
        int prev = 0;
        for(int[] h: height){
            // start,来了就offer
            if(h[1]<0){
                q.offer(-h[1]);
            }
            //end,走了影响力没了，就remove
            else{
                q.remove(h[1]);
            }
            
            int cur = q.peek();
            //只要当前peek和上一次的peek不一样，那么就往result里放 current 时间和current peek高度
            //想一个高低，低高两种情况
            if(prev!=cur){
                res.add(new int[]{h[0], cur});
            }
            prev = cur;
        }
        return res;
    }
}
