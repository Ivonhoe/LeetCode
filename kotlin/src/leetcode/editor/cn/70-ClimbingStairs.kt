//假设你正在爬楼梯。需要 n 阶你才能到达楼顶。 
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶
// 
// Related Topics 动态规划 
// 👍 1479 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun climbStairs(n: Int): Int {
        return solution2(n)
    }

    fun solution2(n: Int): Int {
        var dp = arrayOfNulls<Int>(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = dp[i - 1]?.plus(dp[i - 2]!!)
        }

        return dp[n]!!
    }

    // 递归，超时
    fun solution1(n: Int): Int {
        if (n == 1) {
            return 1
        } else if (n == 2) {
            return 2
        } else {
            return solution1(n - 1) + solution1(n - 2)
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
