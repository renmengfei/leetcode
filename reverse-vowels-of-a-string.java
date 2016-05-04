public class Solution {
    public String reverseVowels(String s) {
        Set<Character> set= new HashSet<Character>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        set.add('A');
        set.add('E');
        set.add('I');
        set.add('O');
        set.add('U');
        
        if(s==null||s.isEmpty()) return s;
        
        char[] c = s.toCharArray();
        int i=0, j=c.length-1;
        
        while(i<j){
            if(!set.contains(c[i])) i++;
            else if(!set.contains(c[j])) j--;
            else{
                swap(c,i++,j--);
            }
        }
        
        return new String(c);
    }
    
    public void swap(char[] c, int i, int j){
        char tmp = c[i];
        c[i]=c[j];
        c[j]=tmp;
    }
}
