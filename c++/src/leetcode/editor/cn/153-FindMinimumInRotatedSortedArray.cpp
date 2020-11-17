//假设按照升序排序的数组在预先未知的某个点上进行了旋转。例如，数组 [0,1,2,4,5,6,7] 可能变为 [4,5,6,7,0,1,2] 。 
//
// 请找出其中最小的元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [3,4,5,1,2]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：nums = [4,5,6,7,0,1,2]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5000 
// -5000 <= nums[i] <= 5000 
// nums 中的所有整数都是 唯一 的 
// nums 原来是一个升序排序的数组，但在预先未知的某个点上进行了旋转 
// 
// Related Topics 数组 二分查找 
// 👍 301 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    int findMin(vector<int> &nums) {
        return solution2(nums);
    }

    // 二分查找
    int solution2(vector<int> &nums) {
        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            if (nums[left] <= nums[right]) {
                return nums[left];
            }

            int mid = left + (right - left) / 2;
            if (nums[left] <= nums[mid]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return -1;
    }

    // O(N)的时间复杂度，遍历数组，比前一个小的节点是最小节点
    int solution1(vector<int> &nums) {
        if (nums.size() == 1) {
            return nums[0];
        }
        int temp = nums[0];
        for (int i = 1; i < nums.size(); i++) {
            if (nums[i] < temp) {
                return nums[i];
            } else {
                temp = nums[i];
            }
        }

        return nums[0];
    }
};
//leetcode submit region end(Prohibit modification and deletion)
