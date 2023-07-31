import java.util.ArrayList;
import java.util.List;

class Solution {
    public int subarraySum(int[] nums, int k) {
        return solution1(nums, k);
    }

    private int solution1(int[] nums, int k) {
        List<Integer> sumList = new ArrayList();
        int sum = 0;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            sumList.add(sum);
        }

        for (int i = 0; i < sumList.size(); i++) {
            int value = sumList.get(i);
            if (value == k) {
                ans++;
            }
            for (int j = 0; j < i; j++) {
                if (value - sumList.get(j) == k) {
                    ans++;
                }
            }
        }

        return ans;
    }

    // 有负数，不能保证窗口增大的时候sum也是增大的，所以不能使用滑动窗口
    private int wrongSolution(int[] nums, int k) {
        int low = 0, high = 0, ans = 0, sum = 0;
        while (high < nums.length) {
            sum += nums[high];
            while (sum >= k && low < nums.length && low <= high) {
                if (sum == k) {
                    ans++;
                }
                sum -= nums[low];
                low++;
            }
            high++;
        }

        return ans;
    }
}