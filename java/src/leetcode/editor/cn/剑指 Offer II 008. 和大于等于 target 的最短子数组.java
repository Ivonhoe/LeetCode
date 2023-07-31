class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE, value = 0;
        for (int i = 0, j = 0; j < nums.length; j++) {
            value += nums[j];
            while (value >= target) {
                ans = Math.min(ans, j - i + 1);
                value -= nums[i++];
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
