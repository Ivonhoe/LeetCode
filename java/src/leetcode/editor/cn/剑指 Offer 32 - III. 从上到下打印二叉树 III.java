/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null){
            return ans;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean revert = false;
        while(!queue.isEmpty()){
            List<Integer> level = new ArrayList<>();
            List<TreeNode> nodes = new ArrayList<>();
            while(!queue.isEmpty()){
                TreeNode node = queue.poll();
                level.add(node.val);
                if(node.left!=null){
                   nodes.add(node.left);
                }
                if(node.right!=null){
                    nodes.add(node.right);
                }
            }
            
            if(revert){
                Collections.reverse(level);
            }
            ans.add(level);
            for(TreeNode node : nodes){
                queue.offer(node);
            }
            revert = !revert;
        }

        return ans;
    }
}