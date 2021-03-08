import java.util.*
import kotlin.collections.HashMap

//你这个学期必须选修 numCourses 门课程，记为 0 到 numCourses - 1 。
//
// 在选修某些课程之前需要一些先修课程。 先修课程按数组 prerequisites 给出，其中 prerequisites[i] = [ai, bi] ，表
//示如果要学习课程 ai 则 必须 先学习课程 bi 。 
//
// 
// 例如，先修课程对 [0, 1] 表示：想要学习课程 0 ，你需要先完成课程 1 。 
// 
//
// 请你判断是否可能完成所有课程的学习？如果可以，返回 true ；否则，返回 false 。 
//
// 
//
// 示例 1： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0]]
//输出：true
//解释：总共有 2 门课程。学习课程 1 之前，你需要完成课程 0 。这是可能的。 
//
// 示例 2： 
//
// 
//输入：numCourses = 2, prerequisites = [[1,0],[0,1]]
//输出：false
//解释：总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0 ；并且学习课程 0 之前，你还应先完成课程 1 。这是不可能的。 
//
// 
//
// 提示： 
//
// 
// 1 <= numCourses <= 105 
// 0 <= prerequisites.length <= 5000 
// prerequisites[i].length == 2 
// 0 <= ai, bi < numCourses 
// prerequisites[i] 中的所有课程对 互不相同 
// 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 
// 👍 714 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        return solution2(numCourses, prerequisites)
    }

    // bfs 入度法
    fun solution1(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // 每个节点的入度数
        var incomeMap = HashMap<Int, Int>()
        for (i in 0 until numCourses) {
            incomeMap[i] = 0
        }

        // 邻接表
        var adjacency = Array(numCourses) {
            IntArray(numCourses) {
                0
            }
        }

        for (item in prerequisites) {
            var start = item[1]
            var end = item[0]
            var incomeCount = incomeMap[end]!!.plus(1)
            incomeMap[end] = incomeCount
            adjacency[start][end] = 1
        }

        var queue = LinkedList<Int>()
        incomeMap.forEach {
            if (it.value == 0) {
                queue.push(it.key)
            }
        }

        var result = mutableListOf<Int>()
        while (queue.isNotEmpty()) {
            var i = queue.pop()
            result.add(i)

            var list = adjacency[i]
            for (i in list.indices) {
                var item = list[i]
                if (item == 0) {
                    continue
                }
                var incomeCount = incomeMap[i]!!.minus(1)
                incomeMap[i] = incomeCount
                if (incomeCount == 0) {
                    queue.push(i)
                }
            }
        }

        return result.size == numCourses
    }

    // dfs
    fun solution2(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        // 标记，0：未访问，1：当前节点已访问（有环），-1：其他节点已访问
        var visited = IntArray(numCourses) {
            0
        }
        // 邻接矩阵
        var adjacency = Array(numCourses) {
            IntArray(numCourses) {
                0
            }
        }
        // 初始化邻接表
        for (item in prerequisites) {
            var start = item[1]
            var end = item[0]
            adjacency[start][end] = 1
        }
        for (i in 0 until numCourses) {
            if (!dfs(adjacency, visited, i)) {
                return false
            }
        }
        return true
    }

    // false: 有环，true：无环
    fun dfs(adjacency: Array<IntArray>, visited: IntArray, index: Int): Boolean {
        if (visited[index] == 1) {
            return false
        } else if (visited[index] == -1) {
            return true
        }
        visited[index] = 1
        adjacency[index].forEachIndexed { i, value ->
            if (value > 0 && !dfs(adjacency, visited, i)) {
                return false
            }
        }
        visited[index] = -1
        return true
    }
}
//leetcode submit region end(Prohibit modification and deletion)
