/*
 * @lc app=leetcode.cn id=215 lang=java
 *
 * [215] 数组中的第K个最大元素
 *
 * https://leetcode-cn.com/problems/kth-largest-element-in-an-array/description/
 *
 * algorithms
 * Medium (64.63%)
 * Likes:    1149
 * Dislikes: 0
 * Total Accepted:    359.5K
 * Total Submissions: 556.3K
 * Testcase Example:  '[3,2,1,5,6,4]\n2'
 *
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。
 * 
 * 示例 1:
 * 
 * 输入: [3,2,1,5,6,4] 和 k = 2
 * 输出: 5
 * 
 * 
 * 示例 2:
 * 
 * 输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
 * 输出: 4
 * 
 * 说明: 
 * 
 * 你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。
 * 
 */

// @lc code=start
class Solution {
    public int findKthLargest(int[] nums, int k) {
        return quickSort(nums, 0, nums.length-1, k);
    }

    private int quickSort(int[] nums, int p, int q, int k){
        if(p>q){
            return -1;
        }

        int index = partition(nums, p, q);
        if(index-p+1==k){
            return nums[index];
        }else if(index-p+1<k){
            return quickSort(nums, index+1, q, k-(index-p+1));
        }else{
            return quickSort(nums, p, index-1, k);
        }
    }

    // public int partition(int[] a, int l, int r) {
    //     int x = a[r], i = l - 1;
    //     for (int j = l; j < r; ++j) {
    //         if (a[j] > x) {
    //             swap(a, ++i, j);
    //         }
    //     }
    //     swap(a, i + 1, r);
    //     return i + 1;
    // }

    //以nums[q]为基准，在[p,q]区间内的分为左右两部分，左边的比基准打，右边的比基准小
    private int partition(int[] nums, int p, int q){
        int left = p;
        int right = q-1;
        int temp = nums[q];
        while(left<right){
            while(left<right && nums[left]>=temp){
                left++;
            }
            while(left<right && nums[right]<=temp){
                right--;
            }
            if(left<right){
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if(right>=p && nums[right]<temp){
            swap(nums, right, q);
            return right;
        }else{
            swap(nums, right+1, q);
            return right+1;
        }
    }

    private void swap(int[] nums, int l, int r){
        int temp = nums[l];
        nums[l] = nums[r];
        nums[r] = temp;
    }
}
// @lc code=end

