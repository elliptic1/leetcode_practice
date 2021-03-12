package sum_range_query;

class SumRangeRange {
    public static void main(String[] args) {

        int[] a = new int[]{1,2,3,4,5,6};

        NumArray n = new NumArray(a);

        n.sumRange(1, 3);
        n.sumRange(2, 4);
        n.sumRange(3, 3);
        n.sumRange(4, 5);
        n.sumRange(1, 2);

    }
}

class NumArray {

    int[] csums;

    public NumArray(int[] nums) {
        if (nums.length > 0) {
            csums = new int[nums.length];
            csums[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                csums[i] = csums[i-1] + nums[i];
            }
        } else {
            csums = new int[1];
            csums[0] = 0;
        }
    }
    public int sumRange(int i, int j) {
        if (i == 0) {
            return csums[j];
        }
        return csums[j] - csums[i-1];
    }
}
