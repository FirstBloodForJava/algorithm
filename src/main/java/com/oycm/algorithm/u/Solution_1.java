package com.oycm.algorithm.u;

import java.util.Arrays;

public class Solution_1 {

    /**
     * 122.买卖股票的最佳时机 II
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

    // 回溯
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

    // 记忆化搜索
    public int method_3(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int[] ints : dp) {
            Arrays.fill(ints, Integer.MIN_VALUE);
        }
        return dfs(prices, prices.length-1, 0, dp);
    }

    public int dfs(int[] prices, int i, int flag, int[][] dp) {
        if (i < 0) {
            return flag == 0 ? 0 : Integer.MIN_VALUE;
        }
        if (dp[i][flag] != Integer.MIN_VALUE) return dp[i][flag];
        if (flag == 0) {
            dp[i][flag] = Math.max(dfs(prices, i-1, 0, dp), dfs(prices, i-1, 1, dp) + prices[i]);
        }else {
            dp[i][flag] = Math.max(dfs(prices, i-1, 1, dp), dfs(prices, i-1, 0, dp) - prices[i]);
        }
        return dp[i][flag];
    }

    // 递推实现
    public int method_4(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[prices.length-1][0];
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] prices = {7, 1, 5, 3, 6, 4};
        System.out.println(solution.method_1(prices));
        System.out.println(solution.method_2(prices));
        System.out.println(solution.method_3(prices));
        System.out.println(solution.method_4(prices));

    }
}
