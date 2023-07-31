import java.util.ArrayList;
import java.util.List;

class Solution {
    public void setZeroes(int[][] matrix) {
        List<int[]> temp = new ArrayList();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    temp.add(new int[] { i, j });
                }
            }
        }
        for (int i = 0; i < temp.size(); i++) {
            _setZero(matrix, temp.get(i)[0], temp.get(i)[1]);
        }
    }

    private void _setZero(int[][] matrix, int k, int m) {
        for (int i = 0; i < matrix[0].length; i++) {
            matrix[k][i] = 0;
        }
        for (int i = 0; i < matrix.length; i++) {
            matrix[i][m] = 0;
        }
    }
}