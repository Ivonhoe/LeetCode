import leetcode.editor.bean.TreeNode

//给定一棵二叉搜索树，请找出其中第k大的节点。
//
// 
//
// 示例 1: 
//
// 输入: root = [3,1,4,null,2], k = 1
//   3
//  / \
// 1   4
//  \
//   2
//输出: 4 
//
// 示例 2: 
//
// 输入: root = [5,3,6,2,4,null,null,1], k = 3
//       5
//      / \
//     3   6
//    / \
//   2   4
//  /
// 1
//输出: 4 
//
// 
//
// 限制： 
//
// 1 ≤ k ≤ 二叉搜索树元素个数 
// Related Topics 树 
// 👍 119 👎 0


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
    fun kthLargest(root: TreeNode?, k: Int): Int {
        var res = 0
        var count = k
        fun dfs(r: TreeNode?) {
            if (r == null) return
            dfs(r.right)
            count = count.minus(1)
            if (count == 0) {
                res = r.`val`
                return
            }
            dfs(r.left)
        }
        dfs(root)
        return res
    }
}
//leetcode submit region end(Prohibit modification and deletion)
