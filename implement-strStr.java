// Method 1: easy way. O(m*n)
public int strStr(String haystack, String needle) {
		if (needle.isEmpty()) return 0;
		if (haystack.isEmpty()) return -1;
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

// Method 2: KMP
http://blog.csdn.net/yearn520/article/details/6729426
