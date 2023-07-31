import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length <= 0) {
            return new int[0];
        }
        int i = 0, j = 0, m = matrix.length, n = matrix[0].length;
        boolean[][] flags = new boolean[m][n];
        List<Integer> ans = new ArrayList();

        // 方向向量
        int[][] degree = { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        int index = 0;
        while (i < m && j < n && i >= 0 && j >= 0 && !flags[i][j]) {
            flags[i][j] = true;
            ans.add(matrix[i][j]);
            int tempI = i + degree[index][0];
            int tempJ = j + degree[index][1];

            if (tempI >= m || tempI < 0 || (tempJ == j && flags[tempI][tempJ])) {
                index = (++index) % 4;
                i = i;
                j = j + degree[index][1];
            } else if (tempJ >= n || tempJ < 0 || (tempI == i && flags[tempI][tempJ])) {
                index = (++index) % 4;
                i = i + degree[index][0];
                j = j;
            } else {
                i = tempI;
                j = tempJ;
            }

        }

        int[] result = new int[ans.size()];
        for (int a = 0; a < ans.size(); a++) {
            result[a] = ans.get(a);
        }
        return result;
    }
}
