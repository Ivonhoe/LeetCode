package ivonhoe.java.leetcode.core;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by ivonhoe on 14-10-19.
 */
public class CombinationSum {

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        doSub(new ArrayList<Integer>(), candidates, target, 0, result);
        return result;
    }

    public static void doSub(ArrayList<Integer> list, int[] candidates, int target,
            int index, List<List<Integer>> result) {

        if (target == 0) {
            result.add(list);
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            int sub = target - candidates[i];
            if (sub >= 0) {
                ArrayList<Integer> arrayList = new ArrayList<Integer>(list);
                arrayList.add(candidates[i]);
                doSub(arrayList, candidates, sub, i, result);
            } else {
                return;
            }
        }
    }

    public static void main(String[] args) {
        int[] candidates = { 8, 7, 4, 3 };
        List<List<Integer>> c = combinationSum(candidates, 11);
        for (int i = 0; i < c.size(); i++) {
            List<Integer> a = c.get(i);
            for (int j = 0; j < a.size(); j++) {
                System.out.print("--" + a.get(j));
            }
            System.out.println("");
        }
    }
}
