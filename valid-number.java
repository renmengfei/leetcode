// e后只能是整数，不能是小数
public class Solution {
    public boolean isNumber(String s) {
        if(s==null) return false;
        int p = 0;
        p+=skipspaces(p,s);
        p+=skipsign(p,s);
        int n1 = skipdigits(p,s);
        p+=n1;
        
        if(p<s.length()&&s.charAt(p)=='.') p++;
        
        int n2 = skipdigits(p,s);
        if(n1+n2==0) return false;
        
        p+=n2;
        
        if(p<s.length() &&(s.charAt(p)=='e'||s.charAt(p)=='E')){
            p++;
            if(p==s.length()) return false;
            p+=skipsign(p,s);
            int n3 = skipdigits(p,s);
            if(n3==0) return false;
            p+=n3;
        }
        p+=skipspaces(p,s);
        
        return p==s.length();
    }
    
    public int skipspaces(int p, String s){
        int i=0;
        while((p+i)<s.length() && s.charAt(p+i)==' ') i++;
        return i;
    }
    
    public int skipsign(int p, String s){
        if(p<s.length() && (s.charAt(p)=='+'||s.charAt(p)=='-')) return 1;
        return 0;
    }
    
    public int skipdigits(int p, String s){
        int i = 0;
        while((p+i<s.length()) && Character.isDigit(s.charAt(p+i)) )i++;
        return i;
    }
   
}
