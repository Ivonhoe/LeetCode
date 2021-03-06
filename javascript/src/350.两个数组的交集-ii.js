/*
 * @lc app=leetcode.cn id=350 lang=javascript
 *
 * [350] 两个数组的交集 II
 *
 * https://leetcode-cn.com/problems/intersection-of-two-arrays-ii/description/
 *
 * algorithms
 * Easy (53.10%)
 * Likes:    406
 * Dislikes: 0
 * Total Accepted:    149.4K
 * Total Submissions: 281.3K
 * Testcase Example:  '[1,2,2,1]\n[2,2]'
 *
 * 给定两个数组，编写一个函数来计算它们的交集。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 输入：nums1 = [1,2,2,1], nums2 = [2,2]
 * 输出：[2,2]
 * 
 * 
 * 示例 2:
 * 
 * 输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * 输出：[4,9]
 * 
 * 
 * 
 * 说明：
 * 
 * 
 * 输出结果中每个元素出现的次数，应与元素在两个数组中出现次数的最小值一致。
 * 我们可以不考虑输出结果的顺序。
 * 
 * 
 * 进阶：
 * 
 * 
 * 如果给定的数组已经排好序呢？你将如何优化你的算法？
 * 如果 nums1 的大小比 nums2 小很多，哪种方法更优？
 * 如果 nums2 的元素存储在磁盘上，内存是有限的，并且你不能一次加载所有的元素到内存中，你该怎么办？
 * 
 * 
 */

// @lc code=start
/**
 * @param {number[]} nums1
 * @param {number[]} nums2
 * @return {number[]}
 */
var intersect = function (nums1, nums2) {
    return solution3(nums1, nums2)
};

// map计数
var solution3 = function (nums1, nums2) {
    var map = new Map()
    for (let i = 0; i < nums1.length; i++) {
        var value = map.get(nums1[i]);
        if (value != undefined) {
            value += 1;
        } else {
            value = 1
        }
        map.set(nums1[i], value)
    }

    var result = [];
    for (let i = 0; i < nums2.length; i++) {
        var value = map.get(nums2[i]);
        if (value > 0) {
            map.set(nums2[i], --value)
            result.push(nums2[i])
        }
    }

    return result;
}

// 排序，双指针
var solution2 = function (nums1, nums2) {
    nums1.sort(sortNumber);
    nums2.sort(sortNumber);
    var i = 0;
    var j = 0;
    var result = [];
    while (i < nums1.length && j < nums2.length) {
        if (nums1[i] == nums2[j]) {
            result.push(nums1[i]);
            i++;
            j++;
        } else if (nums1[i] < nums2[j]) {
            i++
        } else {
            j++
        }
    }
    return result
}

function sortNumber(a, b) {
    return a - b
}

// 枚举法
var solution1 = function (nums1, nums2) {
    var result = [];
    for (let i = 0; i < nums1.length; i++) {
        for (let j = 0; j < nums2.length; j++) {
            if (nums1[i] == nums2[j]) {
                result.push(nums1[i])
                nums2[j] = '#'
                break;
            }
        }
    }

    return result
}
// @lc code=end