/**
 * Created by ivonhoe on 14-10-17.
 */
public class CountAndSay {

    public static String countAndSay(int n) {
        String seed = "1";
        for (int i = 1; i < n; i++) {
            int index = 0;
            String seed2 = "";
            char say = seed.charAt(index);
            int count = 0;
            int outIndex = 0;
            while (index < seed.length()) {
                if (say == seed.charAt(index)) {
                    count++;
                } else {
                    seed2 += "" + count + say;
                    say = seed.charAt(index);
                    count = 1;
                    outIndex = index;
                }
                index++;
            }
            if (outIndex < index) {
                seed2 += "" + count + say;
            }
            seed = seed2;
        }

        return seed;
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(10));
    }
}
