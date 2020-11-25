//你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都 围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。同时，相邻的
//房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。 
//
// 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,3,2]
//输出：3
//解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。
// 
//
// 示例 2： 
//
// 
//输入：nums = [1,2,3,1]
//输出：4
//解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
//     偷窃到的最高金额 = 1 + 3 = 4 。 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 100 
// 0 <= nums[i] <= 1000 
// 
// Related Topics 动态规划 
// 👍 426 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int rob(vector<int> &nums) {
        if (nums.size() == 0) {
            return 0;
        }
        if (nums.size() == 1) {
            return nums[0];
        }

        // 包含第一个元素不包含最后一个元素，包含最后一个元素不包含第一个元素
        // 两个数组分别求最大值，然后取最大值
        return max(robber(nums, 0, nums.size() - 2), robber(nums, 1, nums.size() - 1));
    }

    int robber(vector<int> &nums, int start, int end) {
        int N = end - start + 1;
        if (N == 1) {
            return nums[start];
        }
        vector<int> dp(N + 1);
        dp[0] = 0;
        dp[1] = nums[start];
        for (int i = 2; i < N + 1; i++) {
            dp[i] = max(dp[i - 1], nums[start + i - 1] + dp[i - 2]);
        }

        return dp[N];
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution solution = Solution();
    vector<int> test = {1, 2, 3, 1};
    solution.rob(test);
}
