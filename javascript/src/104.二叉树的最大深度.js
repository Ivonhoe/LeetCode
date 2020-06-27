/*
 * @lc app=leetcode.cn id=104 lang=javascript
 *
 * [104] 二叉树的最大深度
 *
 * https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/description/
 *
 * algorithms
 * Easy (73.51%)
 * Likes:    573
 * Dislikes: 0
 * Total Accepted:    194.9K
 * Total Submissions: 265K
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * 给定一个二叉树，找出其最大深度。
 * 
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 
 * 说明: 叶子节点是指没有子节点的节点。
 * 
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * 
 * ⁠   3
 * ⁠  / \
 * ⁠ 9  20
 * ⁠   /  \
 * ⁠  15   7
 * 
 * 返回它的最大深度 3 。
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
 * @return {number}
 */
var maxDepth = function (root) {
    return solution1(root)
};

function solution1 (root) {
    if (root == null) {
        return 0
    }

    var left = solution1(root.left)
    var right = solution1(root.right)
    return Math.max(left, right) + 1
}

/**
 * dfs
 * @param {TreeNode} root 
 */
function solution2 (root) {
    if (root == null) {
        return 0
    }

    var tempNode = function (node, depth) {
        this.node = node
        this.depth = depth
    }

    var queue = []
    queue.push(new tempNode(root, 1))
    var maxDepth = 0
    while (queue.length > 0) {
        var object = queue.pop()
        maxDepth = Math.max(object.depth, maxDepth)
        var currentNode = object.node
        if (currentNode != null) {
            if (currentNode.right != null) {
                queue.push(new tempNode(currentNode.right, object.depth + 1))
            }
            if (currentNode.left != null) {
                queue.push(new tempNode(currentNode.left, object.depth + 1))
            }
        }

    }

    return maxDepth
}

/**
 * bfs
 * @param {TreeNode} root 
 */
function solution3 (root) {
}
// @lc code=end

