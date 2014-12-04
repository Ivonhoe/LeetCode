package core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ivonhoe on 14-10-21.
 */
public class ThreeSum {
    public static List<List<Integer>> threeSum(int[] num) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        Arrays.sort(num);
        for (int i = 0; i < num.length; i++) {
            int target = 0 - num[i];
            for (int j = i + 1, k = num.length - 1; j < k; ) {
                int a = num[j];
                int b = num[k];
                if (a + b == target) {
                    ArrayList<Integer> list = new ArrayList<Integer>();
                    list.add(num[i]);
                    list.add(a);
                    list.add(b);
                    result.add(list);
                    j++;
                    k--;
                } else if (a + b > target) {
                    k--;
                } else if (a + b < target) {
                    j++;
                }
            }
        }

        // remove duplicated items.
        for (int i = result.size() - 1; i >= 1; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (result.get(i).get(0) == result.get(j).get(0)
                        && result.get(i).get(1) == result.get(j).get(1)
                        && result.get(i).get(2) == result.get(j).get(2)) {
                    result.remove(j);
                    i--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] number = { -1, 0, 1, 2, -1, -4 };
        List<List<Integer>> c = threeSum(number);

        for (int i = 0; i < c.size(); i++) {
            List<Integer> a = c.get(i);
            for (int j = 0; j < a.size(); j++) {
                System.out.print("**" + a.get(j));
            }
            System.out.println("");
        }
    }
}
