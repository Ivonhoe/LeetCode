//给你两个数组，arr1 和 arr2， 
//
// 
// arr2 中的元素各不相同 
// arr2 中的每个元素都出现在 arr1 中 
// 
//
// 对 arr1 中的元素进行排序，使 arr1 中项的相对顺序和 arr2 中的相对顺序相同。未在 arr2 中出现过的元素需要按照升序放在 arr1 的末
//尾。 
//
// 
//
// 示例： 
//
// 
//输入：arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
//输出：[2,2,2,1,4,3,3,9,6,7,19]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr1.length, arr2.length <= 1000 
// 0 <= arr1[i], arr2[i] <= 1000 
// arr2 中的元素 arr2[i] 各不相同 
// arr2 中的每个元素 arr2[i] 都出现在 arr1 中 
// 
// Related Topics 排序 数组 
// 👍 147 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
public:
    vector<int> relativeSortArray(vector<int> &arr1, vector<int> &arr2) {
        vector<int> result;
        int freq[1001] = {0};
        for (auto num :arr1) freq[num]++;
        for (int i = 0; i < arr2.size(); i++) {
            while (freq[arr2[i]]) {
                result.push_back(arr2[i]);
                freq[arr2[i]]--;
            }
        }
        for (int i = 0; i < 1001; i++) {
            while (freq[i]) {
                result.push_back(i);
                freq[i]--;
            }
        }
        return result;
    }
};
//leetcode submit region end(Prohibit modification and deletion)
