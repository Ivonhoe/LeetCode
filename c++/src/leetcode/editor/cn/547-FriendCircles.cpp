//班上有 N 名学生。其中有些人是朋友，有些则不是。他们的友谊具有是传递性。如果已知 A 是 B 的朋友，B 是 C 的朋友，那么我们可以认为 A 也是 C 
//的朋友。所谓的朋友圈，是指所有朋友的集合。 
//
// 给定一个 N * N 的矩阵 M，表示班级中学生之间的朋友关系。如果M[i][j] = 1，表示已知第 i 个和 j 个学生互为朋友关系，否则为不知道。你
//必须输出所有学生中的已知的朋友圈总数。 
//
// 
//
// 示例 1： 
//
// 输入：
//[[1,1,0],
// [1,1,0],
// [0,0,1]]
//输出：2 
//解释：已知学生 0 和学生 1 互为朋友，他们在一个朋友圈。
//第2个学生自己在一个朋友圈。所以返回 2 。
// 
//
// 示例 2： 
//
// 输入：
//[[1,1,0],
// [1,1,1],
// [0,1,1]]
//输出：1
//解释：已知学生 0 和学生 1 互为朋友，学生 1 和学生 2 互为朋友，所以学生 0 和学生 2 也是朋友，所以他们三个在一个朋友圈，返回 1 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 200 
// M[i][i] == 1 
// M[i][j] == M[j][i] 
// 
// Related Topics 深度优先搜索 并查集 
// 👍 380 👎 0

#include "vector"

using namespace std;

//leetcode submit region begin(Prohibit modification and deletion)

// 并查集的简单实现
class UnionFind {
private:
    vector<int> parents;
    int count;

public:
    UnionFind(int n) {
        count = n;
        parents = vector<int>(n);
        for (int i = 0; i < n; i++) {
            parents[i] = i;
        }
    }

    int find(int x) {
        while (parents[x] != x) {
            x = parents[x];
        }
        return x;
    }

    // 先不考虑按秩合并（merge by rank）
    void merge(
            const int a,
            const int b
    ) {
        if (a == b) return; // 自已和自已合并?????

        const int pa = find(a);
        const int pb = find(b);
        if (pa == pb) return; // a and b 已经在同一集合(set)/簇(cluster)/连通分量(connected components)里!

        parents[pb] = pa;
        --count;
    }

    int getCount() {
        return count;
    }


};

class Solution {
public:
    int findCircleNum(vector<vector<int>> &M) {
        return solution2(M);
    }

    int solution2(vector<vector<int>> &M) {
        UnionFind *unionFind = new UnionFind(M.size());
        for (int i = 0; i < M.size(); i++) {
            for (int j = 0; j < M.size(); j++) {
                if (M[i][j] == 1) {
                    unionFind->merge(i, j);
                }
            }
        }

        return unionFind->getCount();
    }

    // dfs
    int solution1(vector<vector<int>> &M) {
        int ans = 0;
        vector<bool> visited(M.size(), false);

        for (int i = 0; i < M.size(); i++) {
            if (!visited[i]) {
                dfs(M, i, visited);
                ans++;
            }
        }
        return ans;
    }

    void dfs(vector<vector<int>> &grid, int row, vector<bool> &visited) {
        visited[row] = true;
        for (int j = 0; j < grid.size(); j++) {
            if (!visited[j] && grid[row][j] == 1) {
                dfs(grid, j, visited);
            }
        }
    }
};
//leetcode submit region end(Prohibit modification and deletion)
