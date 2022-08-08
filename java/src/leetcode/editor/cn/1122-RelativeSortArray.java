package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=1122 lang=java
 *
 * [1122] Relative Sort Array
 *
 * https://leetcode-cn.com/problems/relative-sort-array/description/
 *
 * algorithms
 * Easy (70.73%)
 * Likes:    228
 * Dislikes: 0
 * Total Accepted:    77.4K
 * Total Submissions: 109.3K
 * Testcase Example:  '[2,3,1,3,2,4,6,7,9,2,19]\n[2,1,4,3,9,6]'
 *
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all
 * elements in arr2 are also in arr1.
 * 
 * Sort the elements of arr1 such that the relative ordering of items in arr1
 * are the same as in arr2. Elements that do not appear in arr2 should be
 * placed at the end of arr1 in ascending order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: arr1 = [28,6,22,8,44,17], arr2 = [22,28,8,6]
 * Output: [22,28,8,6,17,44]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * All the elements of arr2 are distinct.
 * Each arr2[i] is in arr1.
 * 
 * 
 */

// @lc code=start
class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        return solution1(arr1, arr2);
    }

    /**
     * todo
     */
    private int[] solution2(int[] arr1, int[] arr2) {
        return null;
    }

    private int[] solution1(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map2 = new HashMap<Integer, Integer>();
        for (int i = 0; i < arr2.length; i++) {
            map2.put(arr2[i], i);
        }

        Map<Integer, List<Integer>> map1 = new HashMap<Integer, List<Integer>>();
        List<Integer> not = new ArrayList<Integer>();
        for (int i = 0; i < arr1.length; i++) {
            if (map2.keySet().contains(arr1[i])) {
                List<Integer> array = map1.getOrDefault(arr1[i], new ArrayList<Integer>());
                array.add(arr1[i]);
                map1.put(arr1[i], array);
            } else {
                not.add(arr1[i]);
            }
        }
        Collections.sort(not);

        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < arr2.length; i++) {
            ans.addAll(map1.get(arr2[i]));
        }
        ans.addAll(not);

        int[] result = new int[ans.size()];
        int index = 0;
        for (int i : ans) {
            result[index++] = i;
        }
        return result;

    }
}
// @lc code=end
