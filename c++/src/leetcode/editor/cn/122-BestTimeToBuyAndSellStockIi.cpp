//给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。 
//
// 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。 
//
// 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。 
//
// 
//
// 示例 1: 
//
// 输入: [7,1,5,3,6,4]
//输出: 7
//解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
// 
//
// 示例 2: 
//
// 输入: [1,2,3,4,5]
//输出: 4
//解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
//     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
//     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
// 
//
// 示例 3: 
//
// 输入: [7,6,4,3,1]
//输出: 0
//解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 3 * 10 ^ 4 
// 0 <= prices[i] <= 10 ^ 4 
// 
// Related Topics 贪心算法 数组 
// 👍 984 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int maxProfit(vector<int> &prices) {
        return solution2(prices);
    }

    int solution1(vector<int> &prices) {
        int result = 0;
        for (int i = 1; i < prices.size(); i++) {
            result += max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }

    int solution2(vector<int> &prices) {
        int buyIndex = 0, saleIndex = 0;
        int index = 0, ans = 0;
        bool buy = true;
        while (index < prices.size()) {
            if (buy) {
                if (prices[index] <= prices[buyIndex]) {
                    // 找低点
                    buyIndex = index;
                    index++;
                } else if (index + 1 < prices.size() && prices[index + 1] >= prices[index]) {
                    // 保证右侧大于当前值，则当前值为最低买点
                    index++;
                } else {
                    buy = false;
                    saleIndex = index;
                }
            } else {
                if (prices[index] >= prices[saleIndex]) {
                    // 找抛出点
                    saleIndex = index;
                    if (index + 1 >= prices.size()) {
                        // 保证最后一天能抛出
                        ans += (prices[saleIndex] - prices[buyIndex]);
                        index++;
                    } else {
                        index++;
                    }
                } else {
                    // 开始下跌前抛出
                    ans += prices[saleIndex] - prices[buyIndex];
                    buyIndex = index;
                    buy = true;
                }
            }
        }
        return ans;
    }

};
//leetcode submit region end(Prohibit modification and deletion)
