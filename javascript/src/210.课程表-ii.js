/*
 * @lc app=leetcode.cn id=210 lang=javascript
 *
 * [210] 课程表 II
 *
 * https://leetcode-cn.com/problems/course-schedule-ii/description/
 *
 * algorithms
 * Medium (52.29%)
 * Likes:    322
 * Dislikes: 0
 * Total Accepted:    55.3K
 * Total Submissions: 105.8K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。
 * 
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]
 * 
 * 给定课程总量以及它们的先决条件，返回你为了学完所有课程所安排的学习顺序。
 * 
 * 可能会有多个正确的顺序，你只要返回一种就可以了。如果不可能完成所有课程，返回一个空数组。
 * 
 * 示例 1:
 * 
 * 输入: 2, [[1,0]] 
 * 输出: [0,1]
 * 解释: 总共有 2 门课程。要学习课程 1，你需要先完成课程 0。因此，正确的课程顺序为 [0,1] 。
 * 
 * 示例 2:
 * 
 * 输入: 4, [[1,0],[2,0],[3,1],[3,2]]
 * 输出: [0,1,2,3] or [0,2,1,3]
 * 解释: 总共有 4 门课程。要学习课程 3，你应该先完成课程 1 和课程 2。并且课程 1 和课程 2 都应该排在课程 0 之后。
 * 因此，一个正确的课程顺序是 [0,1,2,3] 。另一个正确的排序是 [0,2,1,3] 。
 * 
 * 
 * 说明:
 * 
 * 
 * 输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 
 * 
 * 提示:
 * 
 * 
 * 这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
 * 通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
 * 
 * 拓扑排序也可以通过 BFS 完成。
 * 
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {number[]}
 */
var findOrder = function(numCourses, prerequisites) {
    return dfsFindOrder(numCourses, prerequisites)
};

// https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
var dfsFindOrder = function (numCourses, prerequisites) {
    let adjacency = Array();
    for (let i = 0; i < numCourses; i++) {
        adjacency[i] = Array()
    }
    // 0:未访问，1：当前节点启动已访问，-1：已被其他节点启动的dfs访问
    let visited = Array(numCourses).fill(0)
    let result = Array()
    for (let i in prerequisites) {
        let end = prerequisites[i][0]
        let start = prerequisites[i][1]
        adjacency[start].push(end)
    }

    var dfs = function (flags, index) {
        // 当前节点的dfs已经访问过了这个节点，说明有环，返回false
        if (flags[index] == 1) {
            return false
        }

        // 其他节点的dfs访问了这个节点，无需重新再访问，认为没有环
        if (flags[index] == -1) {
            return true
        }
        // 开始访问该节点，标记为1
        flags[index] = 1
        for (let j = 0; j < adjacency[index].length; j++) {
            // 依次访问当前节点的所有邻接节点,如果邻接节点启动的dfs有环，直接返回false
            if (!dfs(flags, adjacency[index][j])) {
                return false
            }
        }
        // 将当前节点设置为已访问过
        flags[index] = -1
        result.push(index)
        return true
    }

    for (let i = 0; i < numCourses; i++) {
        // 依次遍历所有节点dfs
        if (!dfs(visited, i)) {
            return []
        }
    }
    return result.reverse()
}

var bfsFindOrder = function (numCourses, prerequisites) {
    let adjacency = Array();
    let incomeMap = new Map();

    for (let i = 0; i < numCourses; i++) {
        adjacency[i] = Array()
        incomeMap.set(i, 0)
    }

    for (let i in prerequisites) {
        let end = prerequisites[i][0]
        let start = prerequisites[i][1]
        adjacency[start].push(end)
        let incomeCount = incomeMap.get(end) || 0
        incomeMap.set(end, ++incomeCount)
    }

    var queue = []

    incomeMap.forEach(function (value, key, map) {
        if (value == 0) {
            queue.push(key)
        }
    });

    var result = []
    while (queue.length > 0) {
        var zero = queue.pop()
        result.push(zero)

        let endList = adjacency[zero]
        for (let i = 0; i < endList.length; i++) {
            let item = endList[i]
            let incomeCount = incomeMap.get(item)
            incomeMap.set(item, --incomeCount)
            if (incomeCount == 0) {
                queue.push(item)
            }
        }
    }

    if (result.length != numCourses) {
        return []
    } else {
        return result
    }
}
// @lc code=end

