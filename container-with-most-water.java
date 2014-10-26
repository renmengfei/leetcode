public class Solution {
    public int maxArea(int[] height) {
        // Note: The Solution object is instantiated only once and is reused by each test case.
        //2 sum原理 O(n)
        if(height==null||height.length<2) return 0;
        int s = 0;
        int e = height.length-1;
        int area = 0;

        while(s!=e){
            area = Math.max(area,(e-s)*Math.min(height[s],height[e]));
            if(height[s]<height[e]){
                s++;
            }
            else e--;
        }
        return area;


    }
}
