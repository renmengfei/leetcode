// Method 1: easy way O(NlogN)
public class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int i = 0;
        int n = citations.length;
        while(i<n && citations[i]<(n-i)){
            i++;
        }
        return n-i;
    }
}

// Method 2: O(N) 
public class Solution {
    public int hIndex(int[] citations) {
        int n = citations.length;
        int[] count = new int[n+1];
        
        for(int c: citations){
            if(c>n){
                count[n]++;
            }
            else{
                count[c]++;
            }
        }
        
        int total = 0;
        for(int i=n;i>=0;i--){
            total += count[i];
            if(total>=i) return i;
        }
        return 0;
    }
}
