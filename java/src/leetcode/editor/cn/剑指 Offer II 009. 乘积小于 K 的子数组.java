class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return solution2(nums, k);
    }

    // 滑动窗口经典
    private int solution2(int[] nums, int k) {
        int ans = 0, value = 1;
        for (int i = 0, j = 0; j < nums.length; j++) {
            // j作为滑动接口右边界，找到以j为结尾的最大边界
            // 则窗口内以j为结尾的连续子数组个数都是满足条件的
            value = value * nums[j];
            while (value >= k && i <= j && i < nums.length) {
                value = value / nums[i++];
            }
            ans += j - i + 1;
        }

        return ans;
    }

    // 暴利遍历
    private int solution1(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            int value = nums[i];
            if (value < k) {
                ans++;
            } else {
                continue;
            }
            for (int j = i + 1; j < nums.length; j++) {
                value = value * nums[j];
                if (value < k) {
                    ans++;
                } else {
                    break;
                }
            }
        }
        return ans;
    }
}