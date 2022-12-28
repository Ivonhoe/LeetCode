package leetcode.editor.cn;

import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=313 lang=java
 *
 * [313] Super Ugly Number
 *
 * https://leetcode-cn.com/problems/super-ugly-number/description/
 *
 * algorithms
 * Medium (60.53%)
 * Likes:    351
 * Dislikes: 0
 * Total Accepted:    55.2K
 * Total Submissions: 95.5K
 * Testcase Example:  '12\n[2,7,13,19]'
 *
 * A super ugly number is a positive integer whose prime factors are in the
 * array primes.
 * 
 * Given an integer n and an array of integers primes, return the n^th super
 * ugly number.
 * 
 * The n^th super ugly number is guaranteed to fit in a 32-bit signed
 * integer.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: n = 12, primes = [2,7,13,19]
 * Output: 32
 * Explanation: [1,2,4,7,8,13,14,16,19,26,28,32] is the sequence of the first
 * 12 super ugly numbers given primes = [2,7,13,19].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: n = 1, primes = [2,3,5]
 * Output: 1
 * Explanation: 1 has no prime factors, therefore all of its prime factors are
 * in the array primes = [2,3,5].
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= n <= 10^5
 * 1 <= primes.length <= 100
 * 2 <= primes[i] <= 1000
 * primes[i] is guaranteed to be a prime number.
 * All the values of primes are unique and sorted in ascending order.
 * 
 * 
 */

// @lc code=start
class Solution {

    // https://leetcode.cn/problems/super-ugly-number/solutions/924673/gong-shui-san-xie-yi-ti-shuang-jie-you-x-jyow/
    public int nthSuperUglyNumber(int n, int[] primes) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        q.add(1);
        while (n-- > 0) {
            int x = q.poll();
            if (n == 0)
                return x;
            for (int k : primes) {
                if (k <= Integer.MAX_VALUE / x)
                    q.add(k * x);
                if (x % k == 0)
                    break;
            }
        }
        return -1; // never
    }
}
// @lc code=end
