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

    public int method_2(int[] prices) {
        return dfs(prices, prices.length-1, 0);
    }

    // dfs(prices, i, 0) 表示第i天结束，不持有股票的最大收益
    // dfs(prices, i, 1) 表示第i天结束，持有股票的最大收益
    /**
     *
     * @param prices
     * @param i 第i天
     * @param flag 0 卖出(不持有); 1 买入(持有)
     * @return 第i天 0/1的最大收益
     */
    public int dfs(int[] prices, int i, int flag) {
        if (i < 0) {
            return flag == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (flag == 0) {
            return Math.max(dfs(prices, i-1, 0), dfs(prices, i-1, 1) + prices[i]);
        }else {
            return Math.max(dfs(prices, i-1, 1), dfs(prices, i-1, 0) - prices[i]);
        }
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.method_1(prices));
        System.out.println(solution.method_2(prices));

    }
}
