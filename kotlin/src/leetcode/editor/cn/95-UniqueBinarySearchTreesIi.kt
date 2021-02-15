import leetcode.editor.bean.TreeNode

//给定一个整数 n，生成所有由 1 ... n 为节点所组成的 二叉搜索树 。
//
// 
//
// 示例： 
//
// 输入：3
//输出：
//[
//  [1,null,3,2],
//  [3,2,null,1],
//  [3,1,null,null,2],
//  [2,1,3],
//  [1,null,2,null,3]
//]
//解释：
//以上的输出对应以下 5 种不同结构的二叉搜索树：
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 8 
// 
// Related Topics 树 动态规划 
// 👍 775 👎 0


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
    fun generateTrees(n: Int): List<TreeNode?> {
        var ans = mutableListOf<TreeNode?>()
        if (n == 0) {
            return ans
        }

        return solution1(1, n)
    }

    // 递归解法
    fun solution1(start: Int, end: Int): List<TreeNode?> {
        var tree = mutableListOf<TreeNode?>()
        if (start > end) {
            tree.add(null)
            return tree
        } else if (start == end) {
            tree.add(TreeNode(start))
            return tree
        }

        for (i in start..end) {
            var left = solution1(start, i - 1)
            var right = solution1(i + 1, end)

            for (leftTree in left) {
                for (rightTree in right) {
                    var root = TreeNode(i)
                    root.left = leftTree
                    root.right = rightTree
                    tree.add(root)
                }
            }
        }
        return tree
    }
}
//leetcode submit region end(Prohibit modification and deletion)
