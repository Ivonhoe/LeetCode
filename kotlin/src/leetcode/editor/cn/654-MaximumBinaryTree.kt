import leetcode.editor.bean.TreeNode

//给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
//
// 
// 二叉树的根是数组 nums 中的最大元素。 
// 左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。 
// 右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。 
// 
//
// 返回有给定数组 nums 构建的 最大二叉树 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,2,1,6,0,5]
//输出：[6,3,5,null,2,0,null,null,1]
//解释：递归调用如下所示：
//- [3,2,1,6,0,5] 中的最大值是 6 ，左边部分是 [3,2,1] ，右边部分是 [0,5] 。
//    - [3,2,1] 中的最大值是 3 ，左边部分是 [] ，右边部分是 [2,1] 。
//        - 空数组，无子节点。
//        - [2,1] 中的最大值是 2 ，左边部分是 [] ，右边部分是 [1] 。
//            - 空数组，无子节点。
//            - 只有一个元素，所以子节点是一个值为 1 的节点。
//    - [0,5] 中的最大值是 5 ，左边部分是 [0] ，右边部分是 [] 。
//        - 只有一个元素，所以子节点是一个值为 0 的节点。
//        - 空数组，无子节点。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,1]
//输出：[3,null,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// 0 <= nums[i] <= 1000 
// nums 中的所有整数 互不相同 
// 
// Related Topics 树 
// 👍 245 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun constructMaximumBinaryTree(nums: IntArray): TreeNode? {
        if (nums == null || nums.isEmpty()) {
            return null
        }
        return solution2(nums, 0, nums.size - 1)
    }

    // 递归构建
    fun solution2(nums: IntArray, start: Int, end: Int): TreeNode? {
        var max = findMaxIndex(nums, start, end)
        return if (max >= 0) {
            var root = TreeNode(nums[max])
            var left = solution2(nums, start, max - 1)
            var right = solution2(nums, max + 1, end)
            root.left = left
            root.right = right
            root
        } else {
            null
        }
    }

    private fun findMaxIndex(nums: IntArray, start: Int, end: Int): Int {
        if (start < 0 || end >= nums.size || start > end) {
            return -1
        }

        var max = Int.MIN_VALUE
        var ans = -1
        for (index in start..end) {
            if (nums[index] > max) {
                max = nums[index]
                ans = index
            }
        }
        return ans
    }

    // 插入构建
    fun solution1(nums: IntArray): TreeNode? {
        if (nums == null || nums.isEmpty()) {
            return null
        }

        var root: TreeNode? = TreeNode(nums[0])
        for (i in 1 until nums.size) {
            root = insertIntoMaxTree(root, nums[i])
        }
        return root
    }

    private fun insertIntoMaxTree(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null || root.`val` < `val`) {
            var tmp = TreeNode(`val`)
            tmp.left = root
            return tmp
        } else {
            var right = insertIntoMaxTree(root.right, `val`)
            root.right = right
            return root
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
