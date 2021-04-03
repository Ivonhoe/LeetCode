//给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点 (i, ai) 。在坐标内画 n 条垂直线，垂直线 i 的两个端点分别为 (i, 
//ai) 和 (i, 0) 。找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。 
//
// 说明：你不能倾斜容器。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：[1,8,6,2,5,4,8,3,7]
//输出：49 
//解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为 49。 
//
// 示例 2： 
//
// 
//输入：height = [1,1]
//输出：1
// 
//
// 示例 3： 
//
// 
//输入：height = [4,3,2,1,4]
//输出：16
// 
//
// 示例 4： 
//
// 
//输入：height = [1,2,1]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// n = height.length 
// 2 <= n <= 3 * 104 
// 0 <= height[i] <= 3 * 104 
// 
// Related Topics 数组 双指针 
// 👍 2324 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    fun maxArea(height: IntArray): Int {
        return solution2(height)
    }

    // 双指针解法，从两头向中间移动，横坐标在减少的情况下
    // 只有改变短板总面积才可能变大
    fun solution2(height: IntArray): Int {
        if (height == null || height.isEmpty()) {
            return 0
        }
        var i = 0
        var j = height.size - 1
        var result = 0
        while (i < j) {
            var s = Math.min(height[i], height[j]) * (j - i)
            if (s > result) {
                result = s
            }

            if (height[i] < height[j]) {
                i += 1
            } else {
                j -= 1
            }
        }

        return result
    }

    // 超时
    fun solution1(height: IntArray): Int {
        var result = 0
        for (i in height.indices) {
            for (j in i until height.size) {
                var min = Math.min(height[i], height[j])
                var area = min * (j - i)
                if (area > result) {
                    result = area
                }
            }
        }

        return result
    }
}
//leetcode submit region end(Prohibit modification and deletion)
