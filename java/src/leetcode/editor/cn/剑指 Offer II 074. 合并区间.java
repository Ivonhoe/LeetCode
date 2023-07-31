import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (v1, v2) -> {
            return v1[0] - v2[0];
        });

        List<int[]> ans = new ArrayList();
        // 在结果集合里的索引，最后一个元素
        int index = -1;
        for (int[] _interver : intervals) {
            // 比较结果集合中最后一个区间的最大值和当前区间的最小值
            if (index == -1 || _interver[0] > ans.get(index)[1]) {
                ans.add(_interver);
                index++;
            } else {
                int[] item = ans.get(index);
                // item[0] = intervals[index][0];
                item[1] = Math.max(item[1], _interver[1]);
            }
        }

        return ans.toArray(new int[ans.size()][]);
    }
}
