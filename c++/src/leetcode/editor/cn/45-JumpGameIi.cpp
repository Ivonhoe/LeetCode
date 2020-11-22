//给定一个非负整数数组，你最初位于数组的第一个位置。 
//
// 数组中的每个元素代表你在该位置可以跳跃的最大长度。 
//
// 你的目标是使用最少的跳跃次数到达数组的最后一个位置。 
//
// 示例: 
//
// 输入: [2,3,1,1,4]
//输出: 2
//解释: 跳到最后一个位置的最小跳跃数是 2。
//     从下标为 0 跳到下标为 1 的位置，跳 1 步，然后跳 3 步到达数组的最后一个位置。
// 
//
// 说明: 
//
// 假设你总是可以到达数组的最后一个位置。 
// Related Topics 贪心算法 数组 
// 👍 755 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int jump(vector<int> &nums) {
        return solution2(nums);
    }

    // 计算每次跳跃的最远距离
    int solution2(vector<int> &nums) {
        int start = 0, end = 1, ans = 0;
        while (end <= nums.size() - 1) {
            int maxPos = 0;
            for (int i = start; i < end; i++) {
                maxPos = max(maxPos, nums[i] + i);
            }
            start = end;
            end = maxPos + 1;
            ans++;
        }
        return ans;
    }

    // 从后向前找，找最远的距离
    int solution1(vector<int> &nums) {
        int position = nums.size() - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; i++) {
                // 从左向右遍历，第一个满足条件的小标，距离终点最远
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }
        return steps;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
