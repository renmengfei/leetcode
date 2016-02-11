// Method 1: easy way. O(m*n)
public int strStr(String haystack, String needle) {
		for (int i = 0;; i++) {
			for (int j = 0;; j++) {
				if (j == needle.length())
					return i;
				if (i + j >= haystack.length())
					return -1;
				if (haystack.charAt(i + j) != needle.charAt(j))
					break;
			}
		}
	}

// Method 2: initial thought
public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (haystack.isEmpty()) return -1;
                
        for(int start=0; start<= haystack.length()-needle.length(); start++){
            //match first
            if(haystack.charAt(start)==needle.charAt(0)){
                int i=0;
                for(;i<needle.length();i++){
                    if(haystack.charAt(start+i)!=needle.charAt(i)) break;
                }
                if(i==needle.length()){
                    return start;
                }
            }
        }
        
        return -1;
        
    }

// Method 3: KMP
http://blog.csdn.net/yearn520/article/details/6729426
