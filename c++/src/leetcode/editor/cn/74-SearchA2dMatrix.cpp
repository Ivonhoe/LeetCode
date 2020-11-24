//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 278 👎 0

#include "vector"

using namespace std;

#include <iostream>
#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    bool searchMatrix(vector<vector<int>> &matrix, int target) {
        if (matrix.size() < 1 || matrix[0].size() < 1) {
            return false;
        }

        int m = matrix.size();
        int n = matrix[0].size();
        int left = 0, right = m * n - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (matrix[middle / n][middle % n] == target) {
                return true;
            } else if (matrix[middle / n][middle % n] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return false;
    }
};
//leetcode submit region end(Prohibit modification and deletion)

int main() {
    Solution solution = Solution();
    vector<vector<int>> matrix{{1,  3,  5,  7},
                               {10, 11, 16, 20},
                               {23, 30, 34, 50}};
    bool result = solution.searchMatrix(matrix, 3);

    cout << result << std::endl;
}

