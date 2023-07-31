class Solution {
    public int multiply(int A, int B) {
        if (A > B) {
            if (B == 1) return A;
            return A + multiply(A, B - 1);
        } else {
            if (A == 1) return B;
            return B + multiply(A - 1, B);
        }
    }
}