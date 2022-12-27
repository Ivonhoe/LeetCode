package leetcode.editor.cn;

import ivonhoe.java.leetcode.bean.TreeNode;

/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] Validate Binary Search Tree
 *
 * https://leetcode-cn.com/problems/validate-binary-search-tree/description/
 *
 * algorithms
 * Medium (35.57%)
 * Likes:    1835
 * Dislikes: 0
 * Total Accepted:    643K
 * Total Submissions: 1.8M
 * Testcase Example:  '[2,1,3]'
 *
 * Given the root of a binary tree, determine if it is a valid binary search
 * tree (BST).
 * 
 * A valid BST is defined as follows:
 * 
 * 
 * The left subtree of a node contains only nodes with keys less than the
 * node's key.
 * The right subtree of a node contains only nodes with keys greater than the
 * node's key.
 * Both the left and right subtrees must also be binary search trees.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [2,1,3]
 * Output: true
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is
 * 4.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -2^31 <= Node.val <= 2^31 - 1
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        // isValidBST(root, null, null);
    }

    // 中序遍历
    long pre = Long.MIN_VALUE;

    private boolean inorderValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        if (!inorderValidBST(root.left)) {
            return false;
        }

        if (root.val <= pre) {
            return false;
        }

        pre = root.val;
        return inorderValidBST(root.right);
    }

    // 先序遍历
    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (root == null) {
            return true;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }

        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }
}
// @lc code=end
