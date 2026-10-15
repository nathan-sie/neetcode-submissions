class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int minprice = prices[0];

        for(int i = 1; i < prices.length; i++){
            minprice = Math.min(minprice,prices[i]);
            res = Math.max(res, prices[i] - minprice);
        }

        return res;
    }
}
