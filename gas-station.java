// Method 1: O(N) time, O(1) space
public int canCompleteCircuit(int[] gas, int[] cost) {
	// sum用于找不符合accumlation>0的点，那么默认让新的start点＝i+1
	int sum = 0;
	int result = -1;
	// total是积累总数
	int total = 0;

	for (int i = 0; i < gas.length; i++) {
		sum += gas[i] - cost[i];
		total += gas[i] - cost[i];
		if (sum < 0) {
			result = i;
			sum = 0;
		}
	}
	return total >= 0 ? result + 1 : -1;
}

