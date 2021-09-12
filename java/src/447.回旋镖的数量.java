/*
 * @lc app=leetcode.cn id=447 lang=java
 *
 * [447] 回旋镖的数量
 *
 * https://leetcode-cn.com/problems/number-of-boomerangs/description/
 *
 * algorithms
 * Medium (60.45%)
 * Likes:    145
 * Dislikes: 0
 * Total Accepted:    22K
 * Total Submissions: 36.1K
 * Testcase Example:  '[[0,0],[1,0],[2,0]]'
 *
 * 给定平面上 n 对 互不相同 的点 points ，其中 points[i] = [xi, yi] 。回旋镖 是由点 (i, j, k) 表示的元组
 * ，其中 i 和 j 之间的距离和 i 和 k 之间的距离相等（需要考虑元组的顺序）。
 * 
 * 返回平面上所有回旋镖的数量。
 * 
 * 
 * 示例 1：
 * 
 * 
 * 输入：points = [[0,0],[1,0],[2,0]]
 * 输出：2
 * 解释：两个回旋镖为 [[1,0],[0,0],[2,0]] 和 [[1,0],[2,0],[0,0]]
 * 
 * 
 * 示例 2：
 * 
 * 
 * 输入：points = [[1,1],[2,2],[3,3]]
 * 输出：2
 * 
 * 
 * 示例 3：
 * 
 * 
 * 输入：points = [[1,1]]
 * 输出：0
 * 
 * 
 * 
 * 
 * 提示：
 * 
 * 
 * n == points.length
 * 1 
 * points[i].length == 2
 * -10^4 i, yi 
 * 所有点都 互不相同
 * 
 * 
 */

// @lc code=start
class Solution {
    public int numberOfBoomerangs(int[][] points) {
        int ans = 0;
        for(int i=0;i<points.length;i++){
            Map<Double,Integer> map = new HashMap<>();
            for(int j=0;j<points.length;j++){
                if(i==j){
                    continue;
                }
                double distance = Math.pow(points[i][0]-points[j][0],2)+Math.pow(points[i][1]-points[j][1],2);
                if(map.containsKey(distance)){
                    int value = map.get(distance);
                    map.put(distance, value+1);
                }else{
                    map.put(distance, 1);
                }
            }

            for(int value: map.values()){
                ans += value*(value-1);
            }
        }

        return ans;
    }
}
// @lc code=end

