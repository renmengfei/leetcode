public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] t1 = version1.trim().split("\\.");
    	String[] t2 = version2.trim().split("\\.");
    	
	// bug: 需要使用max而不是min，例如1.0，1
    	int len = Math.max(t1.length, t2.length);
    	for(int i=0;i<len;i++){
    		int v1=0, v2=0;
    		if(i<t1.length) v1 = Integer.parseInt(t1[i]);
    		if(i<t2.length) v2 = Integer.parseInt(t2[i]);
    		if(v1>v2) return 1;
    		if(v1<v2) return -1;
    	}
        return 0;
    }
}
