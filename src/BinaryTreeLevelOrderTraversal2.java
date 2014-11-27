import data.YLog;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by ivonhoe on 14-10-23.
 */
public class BinaryTreeLevelOrderTraversal2 {

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> allLevel = new ArrayList<List<Integer>>();
        Queue queue = new LinkedList();
        Queue sameLevel = new LinkedList();
        queue.offer(root);
        TreeNode p;
        List<Integer> level = new ArrayList<Integer>();

        while (!queue.isEmpty() && queue.peek() != null) {
            p = (TreeNode) queue.poll();
            level.add(p.val);
            if (p.left != null) {
                sameLevel.offer(p.left);
            }
            if (p.right != null) {
                sameLevel.offer(p.right);
            }
            if (queue.isEmpty()) {
                queue.addAll(sameLevel);
                sameLevel.clear();
                allLevel.add(level);
                level = new ArrayList<Integer>();
            }
        }

        return allLevel;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        TreeNode lLeft = new TreeNode(4);
        TreeNode lRight = new TreeNode(5);
        TreeNode rLeft = new TreeNode(6);
        TreeNode rRight = new TreeNode(7);
        root.right = right;
        root.left = left;
        left.left = lLeft;
        left.right = lRight;
        right.left = rLeft;
        right.right = rRight;

        BinaryTreeLevelOrderTraversal2 levelOrderTraversal2 = new BinaryTreeLevelOrderTraversal2();
        List<List<Integer>> result = levelOrderTraversal2.levelOrderBottom(root);
        YLog.d(result);
    }
}
