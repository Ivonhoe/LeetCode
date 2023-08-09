/*
 * @lc app=leetcode.cn id=543 lang=java
 *
 * [543] Diameter of Binary Tree
 *
 * https://leetcode.cn/problems/diameter-of-binary-tree/description/
 *
 * algorithms
 * Easy (58.65%)
 * Likes:    1386
 * Dislikes: 0
 * Total Accepted:    334.9K
 * Total Submissions: 570.1K
 * Testcase Example:  '[1,2,3,4,5]'
 *
 * Given the root of a binary tree, return the length of the diameter of the
 * tree.
 * 
 * The diameter of a binary tree is the length of the longest path between any
 * two nodes in a tree. This path may or may not pass through the root.
 * 
 * The length of a path between two nodes is represented by the number of edges
 * between them.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,2,3,4,5]
 * Output: 3
 * Explanation: 3 is the length of the path [4,2,1,3] or [5,2,1,3].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1,2]
 * Output: 1
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [1, 10^4].
 * -100 <= Node.val <= 100
 * 
 * 
 */

// @lc code=start

import ivonhoe.java.leetcode.bean.TreeNode;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public int diameterOfBinaryTree(TreeNode root) {
        depth(root);
        return max;
    }

    private int max = 0;

    private int depth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = depth(root.left);
        int right = depth(root.right);

        max = Math.max(left + right, max);
        return Math.max(left, right) + 1;
    }
}
// @lc code=end
