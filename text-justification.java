//corner case太多，其实题目不难
// len=-1   len+word +1 <= maxLen很巧妙
public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        
        int i=0;
        while(i<words.length){
            int w = i;
            int len = -1;
            
            for(;w<words.length && len+words[w].length()+1 <=maxWidth; w++){
                len+=words[w].length()+1;
            }
            
            StringBuilder sb = new StringBuilder(words[i]);
            int space=1, extra=0;
            
	    // w=i+1导致除法0， w=i+1意味着一个单词word[i]长度达到maxWidth
	    // w=words.length，最后一行只是左对齐，不需要右边对齐
	    // ["What","must","be","shall","be."], 12
            // expected: ["What must be","shall be.   "], 而不是["What must be","shall    be."]
            if(w!=i+1 && w!=words.length){
                space = (maxWidth - len) / (w-i-1)  + 1;
                extra = (maxWidth - len) % (w-i-1);
            }
            
            for(int j=i+1; j<w;j++){
                for(int s=0;s<space; s++) sb.append(' ');
                if(extra-->0) sb.append(' ');
                sb.append(words[j]);
            }
            
            int more = maxWidth-sb.length();
            while(more-->0) sb.append(' ');
            result.add(sb.toString());
            i = w;
        }
        
        return result;
    }
}
