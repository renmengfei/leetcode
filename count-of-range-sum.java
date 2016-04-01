// 巧妙滴利用了mergesort， 每次返回count，这样拿到左边的count，右边的count，该做merge操作了
// 最后的count=左边+右边+merge
// O(nlogn)
// 其实可以先sort sums，用nlogn时间，再for 循环 n个sums，每个sum，binary search找lower upper的边界
// sums用long存，因为sum会大于max

public class Solution {
    public int countRangeSum(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n+1];
        for (int i = 0; i < n; ++i)
            sums[i + 1] = sums[i] + nums[i];
        return countWhileMergeSort(sums, 0, n, lower, upper);
    }
    
    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end <= start) return 0;
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper) 
                  + countWhileMergeSort(sums, mid+1, end, lower, upper);
        int j = mid+1, k = mid+1, t = mid+1;
        // note: cache的作用就是merge sort中，sort的步骤, 这个方法，cache里只放比nums[i]小的数，很巧妙
        long[] cache = new long[end - start+1];
        for (int i = start, r = 0; i <= mid; ++i, ++r) {
            while (k <= end && sums[k] - sums[i] < lower) k++;
            while (j <= end && sums[j] - sums[i] <= upper) j++;
            while (t <= end && sums[t] < sums[i]) cache[r++] = sums[t++];
	    //最后不要忘记append nums[i]
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
}
