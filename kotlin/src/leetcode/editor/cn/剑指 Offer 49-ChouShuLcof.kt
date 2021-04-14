import java.util.*
import kotlin.collections.HashSet

//我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
//
// 
//
// 示例: 
//
// 输入: n = 10
//输出: 12
//解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。 
//
// 说明: 
//
// 
// 1 是丑数。 
// n 不超过1690。 
// 
//
// 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/ 
// Related Topics 数学 
// 👍 147 👎 0


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
