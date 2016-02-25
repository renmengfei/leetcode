// Method 1: binary search
public class Solution {
    public int mySqrt(int x) {
        if (x == 0)
        return 0;
        int left = 1, right = x;
        while (true) {
            int mid = left + (right - left)/2;
            if (mid > x/mid) {
                right = mid - 1;
            } else {
                if (mid + 1 > x/(mid + 1))
                    return mid;
                left = mid + 1;
            }
        }
    }
}

// Method 2: Newton method 
    public int sqrt(int x) {
        if(x<=0) return 0;
        
        double prev =0;
        double cur =1;
        
        while(cur!=prev){
            prev = cur;
            cur = (cur+(double)x/cur)/2;
        }
        
        return (int)cur;
    }
