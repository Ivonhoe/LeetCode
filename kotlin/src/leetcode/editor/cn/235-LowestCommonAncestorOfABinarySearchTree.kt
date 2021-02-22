import leetcode.editor.bean.TreeNode

//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
// Related Topics 树 
// 👍 533 👎 0


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

    fun solution2(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (null == root || null == p || null == q) {
            return root
        }

        if ((root.`val` - p.`val`) * (root.`val` - q.`val`) <= 0) {
            return root
        }

        var next = if (p.`val` < root.`val`) root.left else root.right
        return solution2(next, p, q)
    }

    fun solution1(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        //如果根节点和p,q的差相乘是正数，说明这两个差值要么都是正数要么都是负数，也就是说
        //他们肯定都位于根节点的同一侧，就继续往下找
        var r = root
        if (null == r || null == p || null == q) {
            return r
        }
        while ((r!!.`val` - p.`val`) * (r.`val` - q.`val`) > 0) {
            r = if (p.`val` < r.`val`) r.left else r.right
        }
        //如果相乘的结果是负数，说明p和q位于根节点的两侧，如果等于0，说明至少有一个就是根节点
        return r
    }
}
//leetcode submit region end(Prohibit modification and deletion)
