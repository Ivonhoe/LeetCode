//给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。 
//
// 示例: 
//
// 输入: [-2,1,-3,4,-1,2,1,-5,4]
//输出: 6
//解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
// 
//
// 进阶: 
//
// 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。 
// Related Topics 数组 分治算法 动态规划 
// 👍 2635 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int maxSubArray(vector<int> &nums) {
        return solution3(nums);
    }

    // 动态规划
    // dp[i]表示nums中以nums[i]结尾的最大子序和
    int solution3(vector<int> &nums) {
        vector<int> dp(nums.size());
        dp[0] = nums[0];
        int ans = dp[0];
        for (int i = 1; i < nums.size(); i++) {
            dp[i] = max(dp[i - 1] + nums[i], nums[i]);
            ans = max(ans, dp[i]);
        }
        return ans;
    }

    // 贪心法
    // 之前所有的sum是否对当前sum有增益，有增益就加上，没有增益就以当前item为子序列的最大值，然后和所有子序列比值
    int solution2(vector<int> &nums) {
        int ans = nums[0];
        int sum = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            if (sum > 0) {
                sum = sum + nums[i];
            } else {
                sum = nums[i];
            }

            ans = max(ans, sum);
        }
        return ans;
    }

    // 穷举出所有的连续子数组，判断最大值
    int solution1(vector<int> &nums) {
        int max = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            int sum = 0;
            for (int j = i; j < nums.size(); j++) {
                sum = sum + nums[j];
                if (sum > max) {
                    max = sum;
                }
            }
        }
        return max;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
