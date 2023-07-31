/*
 * @lc app=leetcode.cn id=429 lang=javascript
 *
 * [429] N叉树的层序遍历
 *
 * https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (67.00%)
 * Likes:    117
 * Dislikes: 0
 * Total Accepted:    32.4K
 * Total Submissions: 48.3K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * 给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
 * 
 * 例如，给定一个 3叉树 :
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 * 返回其层序遍历:
 * 
 * [
 * ⁠    [1],
 * ⁠    [3,2,4],
 * ⁠    [5,6]
 * ]
 * 
 * 
 * 
 * 
 * 说明:
 * 
 * 
 * 树的深度不会超过 1000。
 * 树的节点总数不会超过 5000。
 * 
 */

// @lc code=start
/**
 * // Definition for a Node.
 * function Node(val,children) {
 *    this.val = val;
 *    this.children = children;
 * };
 */

/**
 * @param {Node} root
 * @return {number[][]}
 */
var levelOrder = function (root) {
    if (root == null) {
        return []
    }

    var ans = []
    var queue = []
    queue.push(root)
    while (queue.length > 0) {
        let list = []
        let ansList = []
        while (queue.length > 0) {
            var temp = queue.shift()
            ansList.push(temp.val)
            for (let i = 0; i < temp.children.length; i++) {
                list.push(temp.children[i])
            }
        }
        ans.push(ansList)
        queue = [...list]
    }

    return ans
};
// @lc code=end