public class NumArray {
    private int[] sums;

    public NumArray(int[] nums) {
        sums= nums;
        for(int i=1; i<nums.length; i++){
            sums[i] += sums[i-1];
        }
    }

    public int sumRange(int i, int j) {
        return i==0 ? sums[j] : sums[j]-sums[i-1];
    }
}

