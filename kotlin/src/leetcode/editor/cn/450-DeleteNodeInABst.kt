import leetcode.editor.bean.TreeNode

//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 说明： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// 示例: 
//
// 
//root = [5,3,6,2,4,null,7]
//key = 3
//
//    5
//   / \
//  3   6
// / \   \
//2   4   7
//
//给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//
//    5
//   / \
//  4   6
// /     \
//2       7
//
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//    5
//   / \
//  2   6
//   \   \
//    4   7
// 
// Related Topics 树 
// 👍 395 👎 0


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
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.`val` == key) {
            // do delete
            // if root.left == null && root.right == null return null
            if (root.left == null) {
                return root.right
            }
            if (root.right == null) {
                return root.left
            }

            // 左右子树都不为null，右子树中选择最小的节点作为根节点
            var minNode = findMin(root.right!!)
            root.`val` = minNode.`val`
            root.right = deleteNode(root.right, minNode.`val`)
        } else if (root.`val` < key) {
            root.right = deleteNode(root.right, key)
        } else {
            root.left = deleteNode(root.left, key)
        }

        return root
    }

    fun findMin(root: TreeNode): TreeNode {
        var temp = root
        while (temp.left != null) {
            temp = temp.left!!
        }

        return temp
    }
}
//leetcode submit region end(Prohibit modification and deletion)
