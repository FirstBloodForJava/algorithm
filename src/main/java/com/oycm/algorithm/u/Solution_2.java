package com.oycm.algorithm.u;

import java.util.Arrays;

public class Solution_2 {


    /**
     * 309.买卖股票的最佳时机含冷冻期
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/
     * @param prices
     * @return
     */
    public int maxProfit(int[] prices) {
        return 1;
    }

    // 回溯+记忆化搜索
    public int method_1(int[] prices) {
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
            dp[i][flag] = Math.max(dfs(prices, i-1, 1, dp), dfs(prices, i-2, 0, dp) - prices[i]);
        }

        return dp[i][flag];
    }

    // 动态规划
    public int method_2(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n+2][2];
        // dfs(-1,1) = -∞
        dp[1][1] = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            dp[i+2][0] = Math.max(dp[i+1][0], dp[i+1][1] + prices[i]);
            dp[i+2][1] = Math.max(dp[i+1][1], dp[i][0] - prices[i]);
        }
        return dp[n+1][0];
    }
}
