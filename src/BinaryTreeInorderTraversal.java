import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Created by ivonhoe on 14-10-22.
 */
public class BinaryTreeInorderTraversal {

    static List<Integer> inorder = new ArrayList<Integer>();

    public List<Integer> inorderTraversal(TreeNode root) {
        //Recursive
        if(root!=null){
            inorderTraversal(root.left);
            inorder.add(root.val);
            inorderTraversal(root.right);
        }
        //Stack
//        Stack stack = new Stack();
//
//        TreeNode p = root;
//        while (p != null || !stack.isEmpty()) {
//            if (p != null) {
//                stack.push(p);
//                p = p.left;
//            } else {
//                p = (TreeNode) stack.pop();
//                inorder.add(p.val);
//                p = p.right;
//            }
//        }

        return inorder;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode right = new TreeNode(2);
        TreeNode left = new TreeNode(3);
        root.right = right;
        root.left = left;
        BinaryTreeInorderTraversal inorderTraversal = new BinaryTreeInorderTraversal();
        List<Integer> inorder = inorderTraversal.inorderTraversal(root);
        for (int i = 0; i < inorder.size(); i++) {
            System.out.print("--" + inorder.get(i));
        }
    }
}
