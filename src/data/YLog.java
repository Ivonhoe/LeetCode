package data;

import java.util.List;

/**
 * Created by ivonhoe on 14-10-23.
 */
public class YLog {
    public static void d(List<List<Integer>> result) {

        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            for (int j = 0; j < list.size(); j++) {
                System.out.print("**" + list.get(j));
            }
            System.out.println();
        }

    }

    public static void d(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.print("**" + result[i]);
        }
    }
}
