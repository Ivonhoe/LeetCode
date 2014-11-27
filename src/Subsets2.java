import data.YLog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ivonhoe on 14-10-28.
 */
public class Subsets2 {
    public List<List<Integer>> subsetsWithDup(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        int number = 1 << num.length;

        Arrays.sort(num);
        for (int i = 0; i < number; i++) {
            List<Integer> list = new ArrayList<Integer>();
            for (int j = 0; j < num.length; j++) {
                if ((i & (1 << j)) > 0) {
                    list.add(num[j]);
                }
            }
            if (!result.contains(list)) {
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3 };
        Subsets2 subsets2 = new Subsets2();
        YLog.d(subsets2.subsetsWithDup(nums));
    }
}
