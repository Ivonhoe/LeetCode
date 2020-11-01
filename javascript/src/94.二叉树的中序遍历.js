/*
 * @lc app=leetcode.cn id=94 lang=javascript
 *
 * [94] 二叉树的中序遍历
 *
 * https://leetcode-cn.com/problems/binary-tree-inorder-traversal/description/
 *
 * algorithms
 * Medium (74.00%)
 * Likes:    763
 * Dislikes: 0
 * Total Accepted:    292.3K
 * Total Submissions: 394.9K
 * Testcase Example:  '[1,null,2,3]'
 *
 * 给定一个二叉树，返回它的中序 遍历。
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
 * 输出: [1,3,2]
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
var inorderTraversal = function (root) {
    return solution2(root)
};

var solution2 = function (root) {
    if (root == null) {
        return []
    }

    var ans = []
    var stack = []
    while (root != null || stack.length > 0) {
        // 先将所有左子树入栈
        while (root != null) {
            stack.push(root)
            root = root.left
        }

        // 获取最左边左子树
        root = stack.pop()
        ans.push(root.val)
        // 遍历右子树的左子树
        root = root.right
    }

    return ans
}
// 递归
var solution1 = function (root) {
    if (root == null) {
        return []
    }

    var result = []
    var traversal = function (node) {
        if (node == null) {
            return
        }
        traversal(node.left)
        result.push(node.val)
        traversal(node.right)
    }
    traversal(root)
    return result
}
// @lc code=end