/*
 * @lc app=leetcode.cn id=239 lang=javascript
 *
 * [239] 滑动窗口最大值
 *
 * https://leetcode-cn.com/problems/sliding-window-maximum/description/
 *
 * algorithms
 * Hard (49.20%)
 * Likes:    603
 * Dislikes: 0
 * Total Accepted:    83.3K
 * Total Submissions: 169.3K
 * Testcase Example:  '[1,3,-1,-3,5,3,6,7]\n3'
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k
 * 个数字。滑动窗口每次只向右移动一位。
 * 
 * 返回滑动窗口中的最大值。
 * 
 * 
 * 
 * 进阶：
 * 
 * 你能在线性时间复杂度内解决此题吗？
 * 
 * 
 * 
 * 示例:
 * 
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 * 输出: [3,3,5,5,6,7] 
 * 解释: 
 * 
 * ⁠ 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 * ⁠1 [3  -1  -3] 5  3  6  7       3
 * ⁠1  3 [-1  -3  5] 3  6  7       5
 * ⁠1  3  -1 [-3  5  3] 6  7       5
 * ⁠1  3  -1  -3 [5  3  6] 7       6
 * ⁠1  3  -1  -3  5 [3  6  7]      7
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * 1 <= nums.length <= 10^5
 * -10^4 <= nums[i] <= 10^4
 * 1 <= k <= nums.length
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums
 * @param {number} k
 * @return {number[]}
 */
var maxSlidingWindow = function (nums, k) {
    return solution2(nums, k)
};

// 用单调栈解决
var solution3 = function (nums, k) {
}

// 双端队列
var solution2 = function (nums, k) {
    var queue = [];
    var result = [];
    for (let i = 0; i < nums.length; i++) {
        // 队首超出窗口范围，移除掉
        if (queue.length > 0 && queue[0] <= i - k) {
            queue.shift();
        }

        // 入队前，把小于当前num[i]的值都移除掉
        while (queue.length > 0 && nums[queue[queue.length - 1]] < nums[i]) {
            queue.pop();
        }
        // 保存数组下标到队列中
        queue.push(i)
        // 如果窗口长度大于k，把队首元素加入结果中
        if (i >= k - 1) {
            result.push(nums[queue[0]])
        }
    }

    return result;
}
// 枚举法超时
var solution1 = function (nums, k) {
    var maxResult = [];
    if (k > nums.length) {
        k = nums.length
    }
    for (let i = 0; i < nums.length - k + 1; i++) {
        var max = undefined;
        for (let j = i; j < i + k; j++) {
            if (max != undefined) {
                max = Math.max(max, nums[j])
            } else {
                max = nums[j]
            }
        }
        maxResult.push(max)
    }

    return maxResult;
}
// @lc code=end