import java.util.*
import kotlin.collections.HashSet

//给你一个整数 n ，请你找出并返回第 n 个 丑数 。
//
// 丑数 就是只包含质因数 2、3 和/或 5 的正整数。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：12
//解释：[1, 2, 3, 4, 5, 6, 8, 9, 10, 12] 是由前 10 个丑数组成的序列。
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
//解释：1 通常被视为丑数。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 1690 
// 
// Related Topics 堆 数学 动态规划 
// 👍 520 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun nthUglyNumber(n: Int): Int {
        var set = HashSet<Long>()
        var priorityQueue = PriorityQueue<Long>()
        set.add(1)
        priorityQueue.add(1)

        val ops = arrayOf(2, 3, 5)
        for (i in 1..n) {
            var it = priorityQueue.poll()
            if (i == n) {
                return it.toInt()
            }

            for (op in ops) {
                var item = it * op
                if (!set.contains(item)) {
                    set.add(item)
                    priorityQueue.add(item)
                }
            }
        }

        return -1
    }
}
//leetcode submit region end(Prohibit modification and deletion)
