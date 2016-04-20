//这道题很简单，精华在于，sort words by length，这样可以提前停止
public class Solution {
    public int maxProduct(String[] words) {
        int max = 0;
        
        Arrays.sort(words, new Comparator<String>(){
            public int compare(String a, String b){
                return b.length() - a.length();
            }
        });
        
        int[] mask = new int[words.length];
        for(int i=0;i<words.length; i++){
            for(char c: words[i].toCharArray()){
                mask[i] |= 1 << (c - 'a');
            }
        }
        
        for(int i=0;i<words.length; i++){
            if(words[i].length() * words[i].length() <= max) break;
            for(int j=i+1; j<words.length; j++) {
                if((mask[i] & mask[j])==0){
                     max = Math.max(max, words[i].length() * words[j].length());
                     break;
                }
            }
        }
        
        return max;
    }
}
