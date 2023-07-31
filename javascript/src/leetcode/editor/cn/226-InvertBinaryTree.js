/*
 * @lc app=leetcode.cn id=226 lang=javascript
 *
 * [226] 翻转二叉树
 *
 * https://leetcode-cn.com/problems/invert-binary-tree/description/
 *
 * algorithms
 * Easy (75.46%)
 * Likes:    473
 * Dislikes: 0
 * Total Accepted:    89.2K
 * Total Submissions: 118.2K
 * Testcase Example:  '[4,2,7,1,3,6,9]'
 *
 * 翻转一棵二叉树。
 * 
 * 示例：
 * 
 * 输入：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 2     7
 * ⁠/ \   / \
 * 1   3 6   9
 * 
 * 输出：
 * 
 * ⁠    4
 * ⁠  /   \
 * ⁠ 7     2
 * ⁠/ \   / \
 * 9   6 3   1
 * 
 * 备注:
 * 这个问题是受到 Max Howell 的 原问题 启发的 ：
 * 
 * 谷歌：我们90％的工程师使用您编写的软件(Homebrew)，但是您却无法在面试时在白板上写出翻转二叉树这道题，这太糟糕了。
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * function TreeNode(val) {
 *     this.val = val;
 *     this.left = this.right = null;
 * }
 */
/**
 * @param {TreeNode} root
 * @return {TreeNode}
 */
var invertTree = function (root) {
    return solution2(root)
};

/**
 * 递归
 * @param {TreeNode} root 
 */
function solution1 (root) {
    if (root == null) {
        return null
    }

    var left = solution1(root.left)
    var right = solution1(root.right)

    root.left = right
    root.right = left
    return root
}

function solution2 (root) {
    if (root == null) {
        return null
    }

    var queue = []
    queue.push(root)
    while (queue.length) {
        var node = queue.pop();
        var temp = node.left
        node.left = node.right
        node.right = temp
        if (node.left) queue.push(node.left)
        if (node.right) queue.push(node.right)
    }

    return root
}
// @lc code=end

