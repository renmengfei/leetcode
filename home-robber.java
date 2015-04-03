// Method 1: initial thoughts, O(n) space,
// DP[i] in node i, if(i-1) rubbed, then DP[i]=DP[i-1]
// if(i-1) not rubbed, then DP[i-2}+num[i]
public int rob(int[] num) {
	int len = num.length;
	if (len < 2) {
		return len == 0 ? 0 : num[0];
	}
	int[] dp = new int[len];
	dp[0] = num[0];
	dp[1] = num[0] > num[1] ? num[0] : num[1];

	for (int i = 2; i < len; i++) {
		dp[i] = Math.max(dp[i - 1], dp[i - 2] + num[i]);
	}
	return dp[len - 1];
}

// Method 2: in place DP. No space needed
public int rob(int[] num) {
	int len = num.length;
	if (len < 2) {
		return len == 0 ? 0 : num[0];
	}
	num[1] = num[0] > num[1] ? num[0] : num[1];

	for (int i = 2; i < len; i++) {
		num[i] = Math.max(num[i - 1], num[i - 2] + num[i]);
	}
	return num[len - 1];
}

// Method3: O(1) space, use two pointers
// use odd, even
public int rob(int[] num) {
	int a = 0;
	int b = 0;

	for (int i = 0; i < num.length; i++) {
		if (i % 2 == 0) {
			a = Math.max(a + num[i], b);
		} else {
			b = Math.max(a, b + num[i]);
		}
	}

	return Math.max(a, b);
}

