/*
 * @lc app=leetcode.cn id=207 lang=javascript
 *
 * [207] 课程表
 *
 * https://leetcode-cn.com/problems/course-schedule/description/
 *
 * algorithms
 * Medium (54.52%)
 * Likes:    665
 * Dislikes: 0
 * Total Accepted:    86.6K
 * Total Submissions: 158.7K
 * Testcase Example:  '2\n[[1,0]]'
 *
 * 你这个学期必须选修 numCourse 门课程，记为 0 到 numCourse-1 。
 * 
 * 在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们：[0,1]
 * 
 * 给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
 * 
 * 
 * 
 * 示例 1:
 * 
 * 输入: 2, [[1,0]] 
 * 输出: true
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
 * 
 * 示例 2:
 * 
 * 输入: 2, [[1,0],[0,1]]
 * 输出: false
 * 解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 输入的先决条件是由 边缘列表 表示的图形，而不是 邻接矩阵 。详情请参见图的表示法。
 * 你可以假定输入的先决条件中没有重复的边。
 * 1 <= numCourses <= 10^5
 * 
 * 
 */

// @lc code=start
/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
    return dfsCanFinish(numCourses, prerequisites)
};

// https://leetcode-cn.com/problems/course-schedule/solution/course-schedule-tuo-bu-pai-xu-bfsdfsliang-chong-fa/
var dfsCanFinish = function (numCourses, prerequisites) {
    let adjacency = Array();
    for (let i = 0; i < numCourses; i++) {
        adjacency[i] = Array()
    }
    // 0:未访问，1：当前节点启动已访问，-1：已被其他节点启动的dfs访问
    let visited = Array(numCourses).fill(0)
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
        return true
    }

    for (let i = 0; i < numCourses; i++) {
        // 依次遍历所有节点dfs
        if (!dfs(visited, i)) {
            return false
        }
    }
    return true
}

var bfsCanFinish = function (numCourses, prerequisites) {
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

    return result.length == numCourses
}
// @lc code=end