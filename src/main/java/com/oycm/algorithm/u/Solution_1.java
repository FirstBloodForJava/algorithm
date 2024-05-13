package com.oycm.algorithm.u;

public class Solution_1 {

    /**
     * 122
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return 0;
    }

    // 贪心: 记录前一天的股票价格pre
    // 当前的价格curr如果<=pre,前一天卖出,收益=0,pre=curr
    // 当前的价格curr如果>pre,今天卖出,收益=curr-pre,pre=curr
    public int method_1(int[] prices) {
        /*int pre = prices[0];
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += pre >= prices[i] ? 0 : prices[i]-pre;
            pre = prices[i];
        }
        return ans;*/

        // 优化

        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            ans += prices[i-1] >= prices[i] ? 0 : prices[i]-prices[i-1];
        }
        return ans;
    }
}
