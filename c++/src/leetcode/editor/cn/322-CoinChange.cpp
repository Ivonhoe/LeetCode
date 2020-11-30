//给定不同面额的硬币 coins 和一个总金额 amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回
// -1。 
//
// 你可以认为每种硬币的数量是无限的。 
//
// 
//
// 示例 1： 
//
// 
//输入：coins = [1, 2, 5], amount = 11
//输出：3 
//解释：11 = 5 + 5 + 1 
//
// 示例 2： 
//
// 
//输入：coins = [2], amount = 3
//输出：-1 
//
// 示例 3： 
//
// 
//输入：coins = [1], amount = 0
//输出：0
// 
//
// 示例 4： 
//
// 
//输入：coins = [1], amount = 1
//输出：1
// 
//
// 示例 5： 
//
// 
//输入：coins = [1], amount = 2
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 1 <= coins.length <= 12 
// 1 <= coins[i] <= 231 - 1 
// 0 <= amount <= 104 
// 
// Related Topics 动态规划 
// 👍 932 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int coinChange(vector<int> &coins, int amount) {
        return solution2(coins, amount);
    }

    int solution2(vector<int> &coins, int amount) {
        int dp[amount + 1];
        dp[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = INT_MAX;
            for (auto coin:coins) {
                if (i - coin >= 0 && dp[i - coin] < min) {
                    min = dp[i - coin] + 1;
                }
            }
            dp[i] = min;
        }

        return dp[amount] == INT_MAX ? -1 : dp[amount];
    }

    // 贪心算法，从大的开始
    int solution1(vector<int> &coins, int amount) {
        if (amount == 0 || coins.size() == 0) {
            return 0;
        }
        sort(coins.rbegin(), coins.rend());
        int ans = INT_MAX;
        coinChange(coins, amount, 0, 0, ans);
        return ans == INT_MAX ? -1 : ans;
    }

    void coinChange(vector<int> &coins, int amount, int c_index, int count, int &ans) {
        if (amount == 0) {
            ans = min(ans, count);
            return;
        }
        if (c_index == coins.size()) {
            return;
        }

        // 贪心并不一定是最优解，优先选大面额的未必是数量最少的最优解。所以需要把所有的解都找到
        for (int k = amount / coins[c_index]; k >= 0 && k + count < ans; k--) {
            coinChange(coins, amount - k * coins[c_index], c_index + 1, count + k, ans);
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
