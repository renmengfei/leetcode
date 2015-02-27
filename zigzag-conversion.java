public class Solution {
	public String convert(String s, int nRows) {
	    if(nRows==1) return s;
		int num = nRows * 2 - 2;

		String[] matrix = new String[nRows];

		for (int i = 0; i < nRows; i++) {
			matrix[i] = "";
		}

		for (int i = 0; i < s.length(); i++) {
			int group = i % num;
			if (group < nRows) {
				matrix[group]+= s.charAt(i);
			} else {
				matrix[num-group] += s.charAt(i);
			}
		}

		String result = "";
		for (int i = 0; i < nRows; i++) {

			result += matrix[i];
		}
		return result;

	}
}
