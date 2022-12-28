package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/*
 * @lc app=leetcode.cn id=973 lang=java
 *
 * [973] K Closest Points to Origin
 *
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/description/
 *
 * algorithms
 * Medium (64.48%)
 * Likes:    378
 * Dislikes: 0
 * Total Accepted:    90.6K
 * Total Submissions: 139.2K
 * Testcase Example:  '[[1,3],[-2,2]]\n1'
 *
 * Given an array of points where points[i] = [xi, yi] represents a point on
 * the X-Y plane and an integer k, return the k closest points to the origin
 * (0, 0).
 * 
 * The distance between two points on the X-Y plane is the Euclidean distance
 * (i.e., √(x1 - x2)^2 + (y1 - y2)^2).
 * 
 * You may return the answer in any order. The answer is guaranteed to be
 * unique (except for the order that it is in).
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: points = [[1,3],[-2,2]], k = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest k = 1 points from the origin, so the answer is just
 * [[-2,2]].
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: points = [[3,3],[5,-1],[-2,4]], k = 2
 * Output: [[3,3],[-2,4]]
 * Explanation: The answer [[-2,4],[3,3]] would also be accepted.
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= k <= points.length <= 10^4
 * -10^4 < xi, yi < 10^4
 * 
 * 
 */

// @lc code=start
class Solution {
    class Node {
        int[] point;
        int value;

        Node(int[] p) {
            this.point = p;
            value = p[0] * p[0] + p[1] * p[1];
        }
    }

    public int[][] kClosest(int[][] points, int k) {
        List<Node> pointNode = new ArrayList<Node>();
        for (int i = 0; i < points.length; i++) {
            pointNode.add(new Node(points[i]));
        }

        Queue<Node> queue = new PriorityQueue<Node>((v1, v2) -> v1.value - v2.value);
        for (Node node : pointNode) {
            queue.offer(node);
        }

        int[][] ans = new int[k][2];
        for (int i = 0; i < k; i++) {
            Node node = queue.poll();
            ans[i][0] = node.point[0];
            ans[i][1] = node.point[1];
        }
        return ans;
    }
}
// @lc code=end
