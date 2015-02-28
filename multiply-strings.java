public static String multiply(String num1, String num2) {
	num1 = new StringBuffer(num1).reverse().toString();
	num2 = new StringBuffer(num2).reverse().toString();

	int l1 = num1.length();
	int l2 = num2.length();

	int[] result = new int[l1 + l2];
	//bug1: 前一位需要先加，再做余
	for (int i = 0; i < l1; i++) {
		for (int j = 0; j < l2; j++) {
			result[i + j] += (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
			result[i + j + 1] += result[i + j] / 10;
			result[i + j] = result[i + j] % 10;
		}
	}

	int i = l1 + l2 - 1;
	// bug: i>0, 防止0*num， 第一位保证0
	while (i > 0 && 0 == result[i])
			i--;

	StringBuffer sb = new StringBuffer();
	// bug: i=0
	while (i >= 0)
		sb.append(result[i--]);
	return sb.toString();
}
