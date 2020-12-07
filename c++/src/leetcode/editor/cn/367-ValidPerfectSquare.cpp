//给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。 
//
// 说明：不要使用任何内置的库函数，如 sqrt。 
//
// 示例 1： 
//
// 输入：16
//输出：True 
//
// 示例 2： 
//
// 输入：14
//输出：False
// 
// Related Topics 数学 二分查找 
// 👍 181 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool isPerfectSquare(int num) {
        int left = 1;
        int right = num;
        while (left <= right) {
            unsigned long long x = left + (right - left) / 2;
            unsigned long long square = x * x;
            if (square > num) {
                right = x - 1;
            } else if (square < num) {
                left = x + 1;
            } else {
                return true;
            }
        }

        return false;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
