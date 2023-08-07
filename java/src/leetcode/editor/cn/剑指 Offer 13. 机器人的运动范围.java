class Solution {
    public int movingCount(int m, int n, int k) {
        return solution1(m, n, k);
    }

    private int solution1(int m, int n, int k) {
        visited = new boolean[m][n];
        dfs(0, 0, m, n, k);
        return count;
    }

    private boolean[][] visited;
    private int count;
    private int[][] direction = { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } };

    private void dfs(int i, int j, int m, int n, int k) {
        visited[i][j] = true;
        count++;

        for (int d = 0; d < direction.length; d++) {
            int newi = direction[d][0] + i;
            int newj = direction[d][1] + j;

            if (newi < 0 || newi >= m || newj < 0 || newj >= n || visited[newi][newj] || !check(newi, newj, k)) {
                continue;
            }

            dfs(newi, newj, m, n, k);
        }
    }

    private boolean check(int i, int j, int k) {
        int sum = number(i) + number(j);
        return sum <= k;
    }

    private int number(int num) {
        int ans = 0;
        while (num > 0) {
            ans += num % 10;
            num = num / 10;
        }
        return ans;
    }

    private int solution2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        int ans = dfs(0, 0, k, visited);
        return ans;
    }

    private int dfs(int i, int j, int k, boolean[][] visited) {
        if (i < 0 || j < 0 || i > visited.length - 1 || j > visited[0].length - 1 || visited[i][j]) {
            return 0;
        }
        int sum = number(i) + number(j);
        if (sum > k) {
            return 0;
        }
        visited[i][j] = true;
        return 1 + dfs(i, j + 1, k, visited) + dfs(i, j - 1, k, visited) + dfs(i + 1, j, k, visited)
                + dfs(i - 1, j, k, visited);
    }

}