package core;

import data.TreeNode;

/**
 * Created by ivonhoe on 14-12-3.
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int depthLeft = maxDepth(root.left);
        int depthRight = maxDepth(root.right);
        return depthLeft > depthRight ? (depthLeft + 1) : (depthRight + 1);
    }

    public static void main(String[] args) {

    }
}
