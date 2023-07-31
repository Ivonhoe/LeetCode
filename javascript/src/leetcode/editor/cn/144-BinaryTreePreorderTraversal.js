/*
 * @lc app=leetcode.cn id=144 lang=javascript
 *
 * [144] 二叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-preorder-traversal/description/
 *
 * algorithms
 * Medium (67.18%)
 * Likes:    386
 * Dislikes: 0
 * Total Accepted:    184.6K
 * Total Submissions: 274.8K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的 前序 遍历。
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
 * 输出: [1,2,3]
 * 
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
var preorderTraversal = function (root) {
    return solution2(root)
};

// 迭代
var solution2 = function (root) {
    if (root == null) {
        return []
    }

    var stack = []
    stack.push(root)
    var result = []
    while (stack.length > 0) {
        var r = stack.pop()
        result.push(r.val)
        if (r.right != null) {
            stack.push(r.right)
        }

        if (r.left != null) {
            stack.push(r.left)
        }
    }
    return result
}

// 递归
var solution1 = function (root) {
    var result = []
    traversal(root, result)
    return result
}

var traversal = function (root, result) {
    if (root == null) {
        return null
    }

    result.push(root.val)
    traversal(root.left, result)
    traversal(root.right, result)
}
// @lc code=end