import java.util.HashMap;

/**
 * Created by ivonhoe on 14-10-21.
 */
public class TwoSum {

    public static int[] twoSum(int[] numbers, int target) {
        int[] result = new int[2];
        // 存储已经访问的number和index
        HashMap<Integer, Integer> indexMap = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            int sub = target - numbers[i];
            if (indexMap.containsKey(sub)) {
                result[0] = indexMap.get(sub);
                result[1] = i + 1;
                return result;
            }
            indexMap.put(numbers[i], i + 1);
        }
        return result;
    }

    public static void main(String[] args) {
        int[] numbers = { 2, 7, 11, 15 };
        int[] result = twoSum(numbers, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println("---result=" + result[i]);
        }
    }
}
