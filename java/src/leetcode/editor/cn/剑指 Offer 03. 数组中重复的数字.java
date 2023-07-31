class Solution {
    public int findRepeatNumber(int[] nums) {
        int[] temp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int val = nums[i];
            if (temp[val] == 1) {
                return val;
            } else {
                temp[val] = 1;
            }
        }

        return -1;
    }
}