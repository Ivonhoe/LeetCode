package ivonhoe.java.leetcode.core;

import ivonhoe.java.leetcode.utils.L;

/**
 * Created by ivonhoe on 14-12-2.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int abs = x < 0 ? -x : x;
        long result = 0;
        while (abs > 0) {
            result = result * 10 + abs % 10;
            abs = abs / 10;
        }
        result = x < 0 ? result * -1 : result;
        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    public static void main(String[] args) {
        int test = 1534236469;
        int result = new ReverseInteger().reverse(test);
        L.d("test=" + result);
    }
}
