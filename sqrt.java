// public int sqrt(int x) {
    //     // Note: The Solution object is instantiated only once and is reused by each test case.
    //     //二分法
    //     //bug mid*mid可能溢出
    //     if(x<0) return -1;
    //     if(x==0) return 0;

    //     int overflow = (int)Math.sqrt(Integer.MAX_VALUE);
    //     int left = 0;
    //     int right = (x/2)<overflow?(x/2+1):overflow;
        
    //     while(right>=left){// 等号是个大bug！！！ sqrt(2),就是问题
    //         int mid = (left+right)/2;
    //         if(mid*mid==x) return mid;
    //         else if(mid*mid<x) left=mid+1;
    //         else right=mid-1;
    //     }
        
    //     return (left+right)/2;
        
    // }
    
    //Newton method
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
