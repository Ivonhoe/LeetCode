/*
 * @lc app=leetcode.cn id=589 lang=javascript
 *
 * [589] N叉树的前序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (74.05%)
 * Likes:    112
 * Dislikes: 0
 * Total Accepted:    51.9K
 * Total Submissions: 70K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的前序遍历。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其前序遍历: [1,3,5,6,2,4]。
 * 
 * 
 * 
 * 说明: 递归法很简单，你可以使用迭代法完成此题吗?
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val, children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node} root
 * @return {number[]}
 */
var preorder = function (root) {
    return solution2(root)
};

// 迭代
var solution2 = function (root) {
    if (root == null) {
        return []
    }
    var stack = []
    var result = []
    stack.push(root)
    while (stack.length > 0) {
        var node = stack.pop()
        result.push(node.val)
        for (let i = node.children.length - 1; i >= 0; i--) {
            stack.push(node.children[i])
        }
    }

    return result
}

// 递归
var solution1 = function (root) {
    let result = []
    var traversal = function (node) {
        if (node == null) {
            return
        }

        result.push(node.val)
        for (let i = 0; i < node.children.length; i++) {
            traversal(node.children[i])
        }
        return
    }
    traversal(root)
    return result
}
// @lc code=end