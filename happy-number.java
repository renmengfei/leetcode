// 结果只有两种，循环到1，  死循环。所以可以用hashset记录所有循环过程
public class Solution {
    public boolean isHappy(int n) {
        HashSet<Integer> set = new HashSet<Integer>();
        set.add(n);
        
        while(n!=1){
            int result = 0;
            
            while(n!=0){
                result+=Math.pow(n%10,2);
                n/=10;
            }
            if(set.contains(result)) return false;
            set.add(result);
            n=result;
        }
        return true;
    }
}
// Method 2: 抽象成check cycle
public class Solution {
    public boolean isHappy(int n) {
        int slow= nextNum(n);
        int fast=nextNum(nextNum(n));
        
        while(fast !=1 && slow!=fast){
            slow=nextNum(slow);
            fast = nextNum(nextNum(fast));
        }
        return fast==1;
    }
    
    public int nextNum(int n){
        int result = 0;
        while(n!=0){
            result+=Math.pow(n%10,2);
            n/=10;
        }
        return result;
    }
}
