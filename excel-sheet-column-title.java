// 区别在于，26进制从0开始，而excel从1开始，所以可以认为成n－1后的26进制
public class Solution {
    public String convertToTitle(int n) {
        String result="";
        while(n>0){
            int digit = n%26;
	    //bug: digit==0需要分情况讨论
            if(digit==0){
                result='Z'+result;
                n=n/26-1;
            }
            else{
                result = (char)(digit+'A'-1)+result;
                n/=26;
            }
        }
        return result;
    }
}

public class Solution {
    public String convertToTitle(int n) {
        String result="";
        while(n>0){
           n-=1;
           char c = (char)(n%26+'A');
           result=c+result;
           n/=26;
        }
        return result;
    }
}
