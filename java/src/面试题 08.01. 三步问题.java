class Solution {
    public int waysToStep(int n) {
        int[] ans = new int[1000000];
        ans[0] = 1;
        ans[1] = 2;
        ans[2] = 4;
        for(int i=3;i<n;i++){
            ans[i] = (((ans[i-1]+ans[i-2])%1000000007)+ans[i-3])%1000000007;
        }
        return ans[n-1];
    }
}