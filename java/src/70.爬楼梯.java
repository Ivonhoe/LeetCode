/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 *
 * https://leetcode-cn.com/problems/climbing-stairs/description/
 *
 * algorithms
 * Easy (52.05%)
 * Likes:    1706
 * Dislikes: 0
 * Total Accepted:    470.1K
 * Total Submissions: 901.8K
 * Testcase Example:  '2'
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * 
 * 注意：给定 n 是一个正整数。
 * 
 * 示例 1：
 * 
 * 输入： 2
 * 输出： 2
 * 解释： 有两种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶
 * 2.  2 阶
 * 
 * 示例 2：
 * 
 * 输入： 3
 * 输出： 3
 * 解释： 有三种方法可以爬到楼顶。
 * 1.  1 阶 + 1 阶 + 1 阶
 * 2.  1 阶 + 2 阶
 * 3.  2 阶 + 1 阶
 * 
 * 
 */

// @lc code=start
class Solution {
    /// 备忘录
    private int[] mem;
    public int climbStairs(int n) {
        mem = new int[n+1];
        return f(n);
    }

    private int f(int n){
        if(n ==1){
            return 1;
        }
        if(n==2){
            return 2;
        }
        if(mem[n]!=0)return mem[n];
        mem[n] = f(n-1)+f(n-2);
        return mem[n];
    }
}
// @lc code=end

