public class Solution {
    public String reverseString(String s) {
        if(s==null||s.isEmpty()) return s;
        
        char[] c = s.toCharArray();
        int i=0,j=c.length-1;
        
        while(i<j){
            swap(c,i++,j--);
        }
        
        return new String(c);
    }
    
    public void swap(char[] c, int i, int j){
        char tmp = c[i];
        c[i]=c[j];
        c[j]=tmp;
    }
}
