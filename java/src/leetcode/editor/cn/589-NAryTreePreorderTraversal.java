import java.util.ArrayList;
import java.util.List;

import ivonhoe.java.leetcode.bean.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N-ary Tree Preorder Traversal
 *
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/description/
 *
 * algorithms
 * Easy (74.85%)
 * Likes:    329
 * Dislikes: 0
 * Total Accepted:    172.9K
 * Total Submissions: 226.2K
 * Testcase Example:  '[1,null,3,2,4,null,5,6]'
 *
 * Given the root of an n-ary tree, return the preorder traversal of its nodes'
 * values.
 * 
 * Nary-Tree input serialization is represented in their level order traversal.
 * Each group of children is separated by the null value (See examples)
 * 
 * 
 * Example 1:
 * 
 * 
 * 
 * 
 * Input: root = [1,null,3,2,4,null,5,6]
 * Output: [1,3,5,6,2,4]
 * 
 * 
 * Example 2:
 * 
 * 
 * 
 * 
 * Input: root =
 * [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,null,13,null,null,14]
 * Output: [1,2,3,6,7,11,14,4,8,12,5,9,13,10]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * The number of nodes in the tree is in the range [0, 10^4].
 * 0 <= Node.val <= 10^4
 * The height of the n-ary tree is less than or equal to 1000.
 * 
 * 
 * 
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 * 
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> preorder(Node root) {
        return solution1(root);
    }

    // 递归
    private List<Integer> solution1(Node root) {
        List<Integer> ans = new ArrayList<Integer>();
        preOrder(root, ans);
        return ans;
    }

    private void preOrder(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (int i = 0; i < root.children.size(); i++) {
            preOrder(root.children.get(i), result);
        }

    }
}
// @lc code=end
