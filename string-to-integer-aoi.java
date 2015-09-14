//(1)sign
//(2)溢出的处理，不能简单的用long,因为long也可能溢出
public class Solution {
    public int atoi(String str) {
      int p = 0;
      int len=str.length();
      //skip spaces
      while(p<len&&str.charAt(p)==' ')p++;
      if(p==len) return 0;
      
      //skip sign
      int sign = 1;
      if(str.charAt(p)=='-'){sign = -1; p++;}
      else if(str.charAt(p)=='+') p++;
      if(p==len) return 0;
      
      long result = 0;
      while(p<len && isdigit(str.charAt(p))){
          int digit = str.charAt(p)-'0';
          // 难点，计算corner case使用max／10, 不能使用result*10+digit> max,因为min会溢出，必须用result跟min／10比较
          if(sign==-1 && result>-((Integer.MIN_VALUE+digit)/10))  
            return Integer.MIN_VALUE;  
        else if(sign==1 && result>(Integer.MAX_VALUE-digit)/10)  
            return Integer.MAX_VALUE; 
          result = result *10 + str.charAt(p)-'0';
          p++;
      }
      
      result*=sign;
      
      return (int)result;
      
    }
    
    public boolean isdigit(char c){
        return c-'0'>=0 && c-'0'<=9;
    }
    
    
}
