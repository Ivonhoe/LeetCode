import leetcode.editor.bean.TreeNode

//给你二叉树的根节点 root 和一个整数 distance 。
//
// 如果二叉树中两个 叶 节点之间的 最短路径长度 小于或者等于 distance ，那它们就可以构成一组 好叶子节点对 。 
//
// 返回树中 好叶子节点对的数量 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 输入：root = [1,2,3,null,4], distance = 3
//输出：1
//解释：树的叶节点是 3 和 4 ，它们之间的最短路径的长度是 3 。这是唯一的好叶子节点对。
// 
//
// 示例 2： 
//
// 
//
// 输入：root = [1,2,3,4,5,6,7], distance = 3
//输出：2
//解释：好叶子节点对为 [4,5] 和 [6,7] ，最短路径长度都是 2 。但是叶子节点对 [4,6] 不满足要求，因为它们之间的最短路径长度为 4 。
// 
//
// 示例 3： 
//
// 输入：root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
//输出：1
//解释：唯一的好叶子节点对是 [2,5] 。
// 
//
// 示例 4： 
//
// 输入：root = [100], distance = 1
//输出：0
// 
//
// 示例 5： 
//
// 输入：root = [1,1,1], distance = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// tree 的节点数在 [1, 2^10] 范围内。 
// 每个节点的值都在 [1, 100] 之间。 
// 1 <= distance <= 10 
// 
// Related Topics 树 深度优先搜索 
// 👍 69 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    var ans: Int = 0
    fun countPairs(root: TreeNode?, distance: Int): Int {
        dfs(root, distance)
        return ans
    }

    fun dfs(root: TreeNode?, distance: Int): MutableList<Int> {
        // 返回所有叶子节点到当前结点的距离
        var result = mutableListOf<Int>()
        if (root == null) {
            return result
        }
        // 叶子节点
        if (root.left == null && root.right == null) {
            result.add(1)
            return result
        }

        var left = dfs(root.left, distance)
        var right = dfs(root.right, distance)
        // 每次向上回溯之前，判断有没有路径小于distance的，有的话+1
        for (l in left) {
            for (r in right) {
                if (l + r <= distance) {
                    ans++
                }
            }
        }

        // 父节点距离叶子节点的距离=当前节点距离叶子节点的距离+1,把结果回溯给父节点
        for (l in left) {
            if (l + 1 > distance) {
                continue
            }
            result.add(l + 1)
        }

        for (r in right) {
            if (r + 1 > distance) {
                continue
            }
            result.add(r + 1)
        }
        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
