//巧妙之处，sign是char而不是+-1，而且sign的作用延迟了一个，每次碰到符号时，做上一个符号的运算。相当于polish notation
// 注意，因为做上一个符号的运算，最后一个sign会被忘记，所以一定要讨论i=len-1的情况，加上最后一个

public class Solution {
    public int calculate(String s) {
        if(s==null || s.isEmpty()) return 0;
        Stack<Integer> stack = new Stack<>();
        
        int num=0;
        char sign='+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                num = num*10+(c-'0');
            }
            
            if((!Character.isDigit(c) && c!=' ') || i==s.length()-1){
                if(sign=='+'){
                    stack.push(num);
                }
                if(sign=='-'){
                    stack.push(-num);
                }
                if(sign=='*'){
                    stack.push(stack.pop()*num);
                }
                if(sign=='/'){
                    stack.push(stack.pop()/num);
                }
                num=0;
                sign=c;
            }
        }
        
        int res = 0;
        while(!stack.isEmpty()){
            res+=stack.pop();
        }
        return res;
    }
}
