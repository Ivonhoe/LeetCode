import leetcode.editor.bean.TreeNode

//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 
// 👍 950 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int = 0) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */

class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        return solution2(root, p, q)
    }

    // 后序遍历
    fun solution1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root == p || root == q) {
            return root
        }

        var left = solution1(root.left, p, q)
        var right = solution1(root.right, p, q)
        // 说明在两侧
        if (left != null && right != null) {
            return root
        }
        // 说明在右侧
        if (left == null) {
            return right
        }
        // 说明在左侧
        if (right == null) {
            return left
        }

        return null
    }


    // 先找到每个节点的父节点
    fun solution2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        var parentMap = HashMap<Int, TreeNode>()
        fun dfs(r: TreeNode?) {
            if (r == null) {
                return
            }

            if (r.left != null) {
                parentMap[r.left!!.`val`] = r
                dfs(r.left)
            }

            if (r.right != null) {
                parentMap[r.right!!.`val`] = r
                dfs(r.right)
            }
        }

        dfs(root)
        var parentP = mutableListOf<Int>()
        var indexP = p
        while (indexP != null) {
            parentP.add(indexP.`val`)
            indexP = parentMap[indexP.`val`]
        }

        var indexQ = q
        while (indexQ != null) {
            if (parentP.indexOf(indexQ.`val`) >= 0) {
                return indexQ
            }
            indexQ = parentMap[indexQ.`val`]
        }

        return null
    }
}
//leetcode submit region end(Prohibit modification and deletion)
