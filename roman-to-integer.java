public class Solution {
   public int romanToInt(String s) {
         
        int result = 0;
        for(int i=0;i<s.length();i++){
            if(i!=s.length()-1 && getInt(s.charAt(i))<getInt(s.charAt(i+1))){
                result = result -getInt(s.charAt(i)) + getInt(s.charAt(++i));
            }
            else result+=getInt(s.charAt(i));
        }
        return result;
    }

    public int getInt(char c){
        switch(c){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
        }
        return 0;
    }
}
