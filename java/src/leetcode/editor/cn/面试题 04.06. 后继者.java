import ivonhoe.java.leetcode.bean.TreeNode;

/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        return solution2(root, p);
    }

    // 中序遍历，p后面第一个比p大的值
    private TreeNode solution2(TreeNode root, TreeNode p) {
        int target = p.val;
        TreeNode currunt = root;
        TreeNode ans = null;
        while (currunt != null) {
            if (currunt.val > target) {
                ans = currunt;
                currunt = currunt.left;
            } else {
                currunt = currunt.right;
            }
        }

        return ans;
    }

    private boolean flag = false;
    private TreeNode ans = null;

    private void inorder(TreeNode root, TreeNode p) {
        if (root == null || ans != null) {
            return;
        }

        inorder(root.left, p);
        if (flag) {
            ans = root;
            // 这里可能执行多次，所以要将flag置成false
            flag = false;
            return;
        }

        if (root == p) {
            flag = true;
        }

        inorder(root.right, p);
    }
}