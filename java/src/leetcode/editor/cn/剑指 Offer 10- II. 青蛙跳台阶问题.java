class Solution {
    public int numWays(int n) {
    int[] data = new int[n+2];
    data[0] = 1;
    data[1] = 1;
    for (var i = 2; i <= n; i++) {
        data[i] = data[i - 1] + data[i - 2];
        data[i] = data[i]%1000000007;
    }

    return data[n];
    }
}