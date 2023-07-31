import ivonhoe.java.leetcode.bean.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public int kthLargest(TreeNode root, int k) {
        inorder(root, k);
        return ans;
    }

    int count = 0;
    int ans = -1;

    private void inorder(TreeNode root, int k) {
        if (root == null) {
            return;
        }

        inorder(root.right, k);
        if (++count > k) {
            return;
        }

        if (count == k) {
            ans = root.val;
            return;
        }

        inorder(root.left, k);
    }
}