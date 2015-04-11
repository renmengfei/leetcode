	public List<List<String>> partition(String s) {
		List<List<String>> result = new ArrayList<>();

		if (s == null || s.length() == 0)
			return result;
		partition(s, 0, new ArrayList<String>(), result);
		return result;
	}

	public void partition(String s, int start, List<String> path, List<List<String>> result) {
		if (start == s.length()) {
			result.add(new ArrayList<String>(path));
		} else {
			for (int i = start + 1; i <= s.length(); i++) {
				if (isPalindrome(s.substring(start, i))) {
					path.add(s.substring(start, i));
					partition(s, i, path, result);
					path.remove(path.size() - 1);
				}
			}
		}
	}

	public boolean isPalindrome(String s) {
		if (s == null || s.length() == 0)
			return true;
		int start = 0;
		int end = s.length() - 1;
		while (start < end) {
			if (s.charAt(start) != s.charAt(end))
				return false;
			start++;
			end--;
		}
		return true;
	}
