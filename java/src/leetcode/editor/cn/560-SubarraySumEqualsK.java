/*
 * @lc app=leetcode.cn id=560 lang=java
 *
 * [560] Subarray Sum Equals K
 *
 * https://leetcode.cn/problems/subarray-sum-equals-k/description/
 *
 * algorithms
 * Medium (44.99%)
 * Likes:    1997
 * Dislikes: 0
 * Total Accepted:    334.3K
 * Total Submissions: 743.6K
 * Testcase Example:  '[1,1,1]\n2'
 *
 * Given an array of integers nums and an integer k, return the total number of
 * subarrays whose sum equals to k.
 * 
 * A subarray is a contiguous non-empty sequence of elements within an
 * array.
 * 
 * 
 * Example 1:
 * Input: nums = [1,1,1], k = 2
 * Output: 2
 * Example 2:
 * Input: nums = [1,2,3], k = 3
 * Output: 2
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= nums.length <= 2 * 10^4
 * -1000 <= nums[i] <= 1000
 * -10^7 <= k <= 10^7
 * 
 * 
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

class Solution {
    public int subarraySum(int[] nums, int k) {
        return solution2(nums, k);
    }

    // hashmap 优化，类似两数之和
    private int solution2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap<Integer, Integer> mp = new HashMap();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    // 前缀和，双重循环，超出时间限制？？
    private int solution1(int[] nums, int k) {
        List<Integer> sumList = new ArrayList();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumList.add(sum);
        }

        for (int i = 0; i < sumList.size(); i++) {
            int value = sumList.get(i);
            if (value == k) {
                ans++;
            }
            for (int j = 0; j < i; j++) {
                if (value - sumList.get(j) == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // 有负数，不能保证窗口增大的时候sum也是增大的，所以不能使用滑动窗口
    private int wrongSolution(int[] nums, int k) {
        int low = 0, high = 0, ans = 0, sum = 0;
        while (high < nums.length) {
            sum += nums[high];
            while (sum >= k && low < nums.length && low <= high) {
                if (sum == k) {
                    ans++;
                }
                sum -= nums[low];
                low++;
            }
            high++;
        }

        return ans;
    }
}
// @lc code=end
