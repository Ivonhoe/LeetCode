package leetcode.editor.cn;

/*
 * @lc app=leetcode.cn id=875 lang=java
 *
 * [875] Koko Eating Bananas
 *
 * https://leetcode-cn.com/problems/koko-eating-bananas/description/
 *
 * algorithms
 * Medium (48.51%)
 * Likes:    417
 * Dislikes: 0
 * Total Accepted:    106.3K
 * Total Submissions: 209.9K
 * Testcase Example:  '[3,6,7,11]\n8'
 *
 * Koko loves to eat bananas. There are n piles of bananas, the i^th pile has
 * piles[i] bananas. The guards have gone and will come back in h hours.
 * 
 * Koko can decide her bananas-per-hour eating speed of k. Each hour, she
 * chooses some pile of bananas and eats k bananas from that pile. If the pile
 * has less than k bananas, she eats all of them instead and will not eat any
 * more bananas during this hour.
 * 
 * Koko likes to eat slowly but still wants to finish eating all the bananas
 * before the guards return.
 * 
 * Return the minimum integer k such that she can eat all the bananas within h
 * hours.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: piles = [3,6,7,11], h = 8
 * Output: 4
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: piles = [30,11,23,4,20], h = 5
 * Output: 30
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: piles = [30,11,23,4,20], h = 6
 * Output: 23
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= piles.length <= 10^4
 * piles.length <= h <= 10^9
 * 1 <= piles[i] <= 10^9
 * 
 * 
 */

// @lc code=start
class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }

        int ans = maxVal;
        int low = 1, high = maxVal;
        while (low <= high) {
            int mid = (high - low) / 2 + low;

            long time = calculateSum(piles, mid);
            // 可能有多个值，找最小的
            if (time <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }

    private long calculateSum(int[] piles, int speed) {
        long sum = 0;
        for (int pile : piles) {
            sum += (pile + speed - 1) / speed;
        }

        return sum;
    }
}
// @lc code=end
