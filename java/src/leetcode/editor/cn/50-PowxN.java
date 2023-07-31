/*
 * @lc app=leetcode.cn id=50 lang=java
 *
 * [50] Pow(x, n)
 *
 * https://leetcode-cn.com/problems/powx-n/description/
 *
 * algorithms
 * Medium (37.53%)
 * Likes:    669
 * Dislikes: 0
 * Total Accepted:    191.1K
 * Total Submissions: 508.7K
 * Testcase Example:  '2.00000\n10'
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，x^n）。
 * 
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2^-2 = 1/2^2 = 1/4 = 0.25
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * -100.0 
 * -2^31 
 * -10^4 
 * 
 * 
 */

// @lc code=start
class Solution {
    public double myPow(double x, int n) {
        if(n>=0){
            return pow(x, n);
        }else{
            return 1.0/pow(x,-n);
        }
    }
    private double pow(double x, int n){
        if(n ==0){
            return 1;
        }
        if(n==1){
            return x;
        }
        double y = pow(x, n/2);
        if(n%2==0){
            return y*y;
        }else{
            return y*y*x;
        }
    }
}
// @lc code=end

