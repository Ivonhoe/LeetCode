/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 *
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
 *
 * algorithms
 * Medium (70.40%)
 * Likes:    1202
 * Dislikes: 0
 * Total Accepted:    242.3K
 * Total Submissions: 344.2K
 * Testcase Example:  '[3,9,20,15,7]\n[9,3,15,20,7]'
 *
 * 给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
 * 
 * 
 * 
 * 示例 1:
 * 
 * 
 * Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
 * Output: [3,9,20,null,null,15,7]
 * 
 * 
 * 示例 2:
 * 
 * 
 * Input: preorder = [-1], inorder = [-1]
 * Output: [-1]
 * 
 * 
 * 
 * 
 * 提示:
 * 
 * 
 * 1 
 * inorder.length == preorder.length
 * -3000 
 * preorder 和 inorder 均无重复元素
 * inorder 均出现在 preorder
 * preorder 保证为二叉树的前序遍历序列
 * inorder 保证为二叉树的中序遍历序列
 * 
 * 
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length-1, inorder, 0, inorder.length -1);
    }
    
    private TreeNode buildTree(int[] preorder, int i, int j, int[] inorder, int m, int n){
        if(i>j || m>n){
            return null;
        }
        
        int val = preorder[i];
        int index = map.get(val);
        
        TreeNode root = new TreeNode(val);
        root.left = buildTree(preorder, i+1, i+index-m ,inorder, m, index-1);
        root.right = buildTree(preorder, i+index-m+1, j, inorder, index+1, n);
        return root;
    }
}
// @lc code=end

