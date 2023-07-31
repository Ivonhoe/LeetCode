import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        int sum = 0;
        int ans = Integer.MIN_VALUE;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, -1);
        for (int i = 0; i < nums.length; i++) {
            // 是1就+1，如果是0就-1，所以如果连续子数组的和为0，则0和1的个数相等
            sum += (nums[i] == 1 ? 1 : -1);
            // 如果map中取到了相同的数值，说明在这两个index之间的连续子数组中0和1的个数是相等的
            if (map.containsKey(sum)) {
                ans = Math.max(ans, i - map.get(sum));
            } else {
                map.put(sum, i);
            }
        }

        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}
