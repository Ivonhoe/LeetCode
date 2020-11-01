/*
 * @lc app=leetcode.cn id=145 lang=javascript
 *
 * [145] 二叉树的后序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Medium (73.36%)
 * Likes:    463
 * Dislikes: 0
 * Total Accepted:    154.5K
 * Total Submissions: 210.6K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 后序 遍历。
 * 
 * 示例:
 * 
 * 输入: [1,null,2,3]  
 * ⁠  1
 * ⁠   \
 * ⁠    2
 * ⁠   /
 * ⁠  3 
 * 
 * 输出: [3,2,1]
 * 
 * 进阶: 递归算法很简单，你可以通过迭代算法完成吗？
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val, left, right) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.left = (left===undefined ? null : left)
 *     this.right = (right===undefined ? null : right)
 * }
 */
/**
 * @param {TreeNode} root
 * @return {number[]}
 */
var postorderTraversal = function (root) {
    return solution1(root)
};

// 迭代
var solution2 = function (root) {
    if (root == null) {
        return []
    }

    var stack = []
    var result = []
    var pre = null
    while (root != null || stack.length > 0) {
        while (root != null) {
            stack.push(stack.left)
            root = stack.left
        }

        root = stack.pop()
        // 从右节点向根节点退，防止再走入右节点
        if (root.right == null || root.right == pre) {
            result.push(root.val)
            pre = root
            root = null
        } else {
            stack.push(root)
            root = root.right
        }
    }

    return result
}

// 递归
var solution1 = function (root) {
    var result = []
    var traversal = function (node) {
        if (node == null) {
            return
        }
        traversal(node.left)
        traversal(node.right)
        result.push(node.val)
    }

    traversal(root)
    return result
}
// @lc code=end