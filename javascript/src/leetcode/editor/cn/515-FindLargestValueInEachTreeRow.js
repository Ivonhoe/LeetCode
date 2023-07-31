/*
 * @lc app=leetcode.cn id=515 lang=javascript
 *
 * [515] 在每个树行中找最大值
 *
 * https://leetcode-cn.com/problems/find-largest-value-in-each-tree-row/description/
 *
 * algorithms
 * Medium (60.48%)
 * Likes:    70
 * Dislikes: 0
 * Total Accepted:    13K
 * Total Submissions: 21.5K
 * Testcase Example:  '[1,3,2,5,3,null,9]'
 *
 * 您需要在二叉树的每一行中找到最大的值。
 * 
 * 示例：
 * 
 * 
 * 输入: 
 * 
 * ⁠         1
 * ⁠        / \
 * ⁠       3   2
 * ⁠      / \   \  
 * ⁠     5   3   9 
 * 
 * 输出: [1, 3, 9]
 * 
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
 * @return {number[]}
 */
var largestValues = function (root) {
    if (!root) {
        return []
    }

    var result = []
    var queue = []
    queue.push(root)
    while (true) {
        if (queue.length == 0) {
            return result
        }
        var list = []
        var length = queue.length;
        var max;
        for (i = 0; i < length; i++) {
            var node = queue.shift()
            list.push(node.val)
            if (i == 0) {
                max = node.val
            } else if (node.val > max) {
                max = node.val
            }
            if (node.left != null) {
                queue.push(node.left)
            }
            if (node.right != null) {
                queue.push(node.right)
            }
        }

        result.push(max)
    }
}
// @lc code=end

