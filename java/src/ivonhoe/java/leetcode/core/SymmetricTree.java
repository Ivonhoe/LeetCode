package ivonhoe.java.leetcode.core;

import ivonhoe.java.leetcode.bean.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ivonhoe on 14-10-29.
 */
public class SymmetricTree {
    List<String> inOrderList = new ArrayList<String>();

    public boolean isSymmetric(TreeNode root) {
        inOrderTraversal(root);
        if (inOrderList.size() < 1) {
            return true;
        }

        int i = 0;
        int j = inOrderList.size() - 1;
        while (i < j) {
            if (!inOrderList.get(i).equals(inOrderList.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    // 中序遍历最重要的问题是空子树需要标记出来
    public void inOrderTraversal(TreeNode root) {
        // if empty node, save as ‘#’ to occupy this place
        if (root == null) {
            inOrderList.add("#");
            return;
        }
        if (root.left == null && root.right == null) {
            inOrderList.add("" + root.val);
        } else {
            inOrderTraversal(root.left);
            inOrderList.add("" + root.val);
            inOrderTraversal(root.right);
        }
    }

    // 第二中方式，判断左右子树是否是镜像
    public boolean isSymmetric2(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode a, TreeNode b) {
        if (a == null && b == null)
            return true;
        if (a == null || b == null)
            return false;  // only one has node in a tree and b tree
        if (a.val != b.val)
            return false;
        return helper(a.left, b.right) && helper(a.right,
                b.left); // a goes in in-order traversal, b goes right first then left.
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        TreeNode left1 = new TreeNode(3);
        TreeNode left2 = new TreeNode(2);
        root.left = left;
        root.right = right;
        left.left = left1;
        right.left = left2;

        SymmetricTree symmticTree = new SymmetricTree();
        System.out.println("--isSymmetric=" + symmticTree.isSymmetric(root));
    }
}
