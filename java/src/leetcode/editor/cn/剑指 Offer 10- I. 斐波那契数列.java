class Solution {
    public int fib(int n) {
    if (n == 0 || n == 1) {
        return n;
    }

    int a = 0, b = 1, sum;
    for (var i = 0; i < n; i++) {
        sum = (a + b) % 1000000007;
        a = b;
        b = sum;
    }

    return a;
    }
}