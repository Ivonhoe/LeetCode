/**
 * Created by ivonhoe on 14-10-15.
 */
public class DistinctSubsequences {
    //T in S
    public static int numDistinct(String S, String T) {
        int m = T.length();
        int n = S.length();
        if (m > n) return 0;    // impossible for subsequence
        int[][] path = new int[m + 1][n + 1];
        for (int k = 0; k <= n; k++)
            path[0][k] = 1;    // initialization

        for (int j = 1; j <= n; j++) {
            for (int i = 1; i <= m; i++) {
                path[i][j] = path[i][j - 1] +
                        (T.charAt(i - 1) == S.charAt(j - 1) ? path[i - 1][j - 1] : 0);
            }
        }

        return path[m][n];
    }

    //最大子序列
    public static int numDistinct2(String S, String T) {
        int m = T.length();
        int n = S.length();

        int[][] path = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++)
            path[i][0] = 0;
        for (int i = 0; i <= n; i++)
            path[0][i] = 0;

        for (int i = 1; i <= m; i++)
            for (int j = 1; j <= n; j++) {
                if (T.charAt(i-1) == S.charAt(j-1)) {
                    path[i][j] = path[i - 1][j - 1] + 1;
                } else {
                    path[i][j] = Math.max(path[i - 1][j], path[i][j - 1]);
                }
            }
        return path[m][n];
    }

    public static void main(String[] args) {
        System.out.println("" + numDistinct("rabbbit", "rabbit"));
        System.out.println("---------" + numDistinct2("belong", "cnblogs"));
    }
}
