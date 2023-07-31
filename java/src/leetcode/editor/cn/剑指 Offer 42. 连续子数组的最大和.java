class Solution {
    // 定义 f[i]f[i] 为考虑以 nums[i]nums[i] 为结尾的子数组的最大值
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        f[0] = nums[0];
        int ans = f[0];
        for(int i=1;i<nums.length;i++){
            f[i] = Math.max(f[i-1]+nums[i], nums[i]);
            ans = Math.max(ans, f[i]);
        }

        return ans;
    }
}