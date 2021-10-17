class Solution {
    public int maxProfit(int[] prices) {
        int a = Integer.MAX_VALUE;
        int ans = 0;
        for(int price : prices){
            a = Math.min(price, a);
            ans = Math.max(ans, price-a);
        }
        return ans;
    }
}