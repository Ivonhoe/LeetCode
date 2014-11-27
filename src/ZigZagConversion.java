/**
 * Created by ivonhoe on 14-10-22.
 */
public class ZigZagConversion {
    public static String convert(String s, int nRows) {
        String result = "";
        if (nRows < 2 || s == null) {
            return s;
        }

        String[] strings = new String[nRows];
        int current = 0;
        int dir = -1;
        for (int i = 0; i < s.length(); i++) {
            if (strings[current] == null) {
                strings[current] = "";
            }
            strings[current] += s.charAt(i);
            if (current == 0 || current == nRows - 1) {
                dir *= -1;
            }
            current += dir;
        }

        for (int i = 0; i < nRows; i++) {
            if (strings[i] != null) {
                result += strings[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        String s = "P";
        System.out.println("s=" + convert(s, 3));
    }
}
