package com.oycm.algorithm.u;

import java.util.Arrays;

/**
 * @author ouyangcm
 * create 2024/5/14 13:11
 */
public class Solution_3 {

    /**
     * 188.买卖股票的最佳时机 IV
     * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/
     * @param k
     * @param prices
     * @return
     */
    public int maxProfit(int k, int[] prices) {
        return 1;
    }

    // 回溯
    public int method_1(int k, int[] prices) {
        return dfs(k, prices, prices.length-1, 0);
    }

    public int dfs(int k, int[] prices, int i, int flag) {
        // 超过交易次数
        if (k < 0) {
            return min;
        }
        if (i < 0) {
            return flag == 0 ? 0 : min;
        }
        if (flag == 0) {
            return Math.max(dfs(k, prices, i-1, 0), dfs(k-1, prices, i-1, 1) + prices[i]);
        }else {
            return Math.max(dfs(k, prices, i-1, 1), dfs(k, prices, i-1, 0) - prices[i]);
        }

    }

    public int method_2(int k, int[] prices) {
        int[][][] dp = new int[prices.length][k+1][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j <= k; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return dfs(k, prices, prices.length-1, 0, dp);
    }

    int min = -10000000;
    public int dfs(int k, int[] prices, int i, int flag, int[][][] dp) {
        // 超过交易次数
        if (k < 0) {
            return min;
        }
        if (i < 0) {
            return flag == 0 ? 0 : min;
        }
        if (dp[i][k][flag] != -1) return dp[i][k][flag];
        if (flag == 0) {
            dp[i][k][flag] = Math.max(dfs(k, prices, i-1, 0, dp), dfs(k-1, prices, i-1, 1, dp) + prices[i]);
        }else {
            dp[i][k][flag] = Math.max(dfs(k, prices, i-1, 1, dp), dfs(k, prices, i-1, 0, dp) - prices[i]);
        }
        return dp[i][k][flag];
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.method_1(2, prices));
        System.out.println(solution.method_2(2, prices));
    }
}
