package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import ivonhoe.java.leetcode.bean.TreeNode;

/*
 * @lc app=leetcode.cn id=145 lang=java
 *
 * [145] Binary Tree Postorder Traversal
 *
 * https://leetcode-cn.com/problems/binary-tree-postorder-traversal/description/
 *
 * algorithms
 * Easy (75.41%)
 * Likes:    962
 * Dislikes: 0
 * Total Accepted:    552.9K
 * Total Submissions: 725.5K
 * Testcase Example:  '[1,null,2,3]'
 *
 * Given the root of a binary tree, return the postorder traversal of its
 * nodes' values.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [1,null,2,3]
 * Output: [3,2,1]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = [1]
 * Output: [1]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of the nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode() {} TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) { this.val = val; this.left
 * = left; this.right = right; } }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        return postorderItration(root);
    }

    private List<Integer> postorderItration(TreeNode root) {
        List<Integer> ans = new ArrayList<Integer>();
        if (root == null) {
            return ans;
        }

        Stack<Object> stack = new Stack<Object>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Object n = stack.pop();
            if (n instanceof TreeNode) {
                TreeNode node = (TreeNode) n;
                stack.push(node.val);
                if (node.right != null) {
                    stack.push(node.right);
                }
                if (node.left != null) {
                    stack.push(node.left);
                }
            } else {
                ans.add((Integer) n);
            }
        }
        return ans;
    }

    private void postorder(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }

        postorder(root.left, ans);
        postorder(root.right, ans);
        ans.add(root.val);
    }
}
// @lc code=end
