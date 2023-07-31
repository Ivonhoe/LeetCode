package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import ivonhoe.java.leetcode.bean.TreeNode;

/*
 * @lc app=leetcode.cn id=102 lang=java
 *
 * [102] Binary Tree Level Order Traversal
 *
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/description/
 *
 * algorithms
 * Medium (64.43%)
 * Likes:    1535
 * Dislikes: 0
 * Total Accepted:    722.3K
 * Total Submissions: 1.1M
 * Testcase Example:  '[3,9,20,null,null,15,7]'
 *
 * Given the root of a binary tree, return the level order traversal of its
 * nodes' values. (i.e., from left to right, level by level).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: root = [3,9,20,null,null,15,7]
 * Output: [[3],[9,20],[15,7]]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: root = [1]
 * Output: [[1]]
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: root = []
 * Output: []
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 2000].
 * -1000 <= Node.val <= 1000
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();
                if (node.left != null) {
                    nodes.add(node.left);
                }
                if (node.right != null) {
                    nodes.add(node.right);
                }
                level.add(node.val);
            }
            for (TreeNode n : nodes) {
                queue.offer(n);
            }
            ans.add(level);
        }

        return ans;
    }

    private List<List<Integer>> ans = new ArrayList<List<Integer>>();

    // 递归实现层序遍历
    private List<List<Integer>> solution2(TreeNode node) {
        dfs(node, 0);
        return ans;
    }

    private void dfs(TreeNode node, int level) {
        if (node == null) {
            return;
        }
        if (level >= ans.size()) {
            ans.add(new ArrayList<Integer>());
        }

        ans.get(level).add(node.val);
        dfs(node.left, level + 1);
        dfs(node.right, level + 1);
    }

}
// @lc code=end
