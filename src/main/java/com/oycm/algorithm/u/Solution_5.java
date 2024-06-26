package com.oycm.algorithm.u;

import java.util.Arrays;

/**
 * @author ouyangcm
 * create 2024/5/15 11:20
 */
public class Solution_5 {

    int min = -10000000;
    /**
     * 最少交易k次的最大收益 k >= 1 (k==0时变成了交易次数不限制)
     * @param k 交易k次
     * @param prices 股票每天的价格
     * @return
     */
    public int minProfit(int k, int[] prices) {
        return 1;
    }

    public int method_1(int k, int[] prices) {
        return dfs(k, prices.length-1, 0, prices);
    }

    public int dfs(int k, int i, int flag, int[] prices) {
        if (i < 0) {
            if (k > 0 || flag == 1) {
                return min;
            }else {
                return 0;
            }
        }
        if (flag == 1) {
            // 持有 = 一直持有/不持有买入
            return Math.max(dfs(k, i-1, 1, prices), dfs(k-1,  i-1, 0, prices) - prices[i]);
        }

        return Math.max(dfs(k, i-1, 0, prices), dfs(k,  i-1, 1, prices) + prices[i]);
    }

    public int method_2(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n+1][k+1][2];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < k+1; j++) {
                Arrays.fill(dp[i][j], min);
            }
        }
        dp[0][0][0] = 0;
        for (int i = 0; i < n; i++) {
            // 交易不限制次数的最大金额
            dp[i+1][0][0] = Math.max(dp[i][0][0], dp[i][0][1] + prices[i]);
            dp[i+1][0][1] = Math.max(dp[i][0][1], dp[i][0][0] - prices[i]);
            for (int j = 1; j < k+1; j++) {
                dp[i+1][j][0] = Math.max(dp[i][j][0], dp[i][j-1][1] + prices[i]);
                dp[i+1][j][1] = Math.max(dp[i][j][1], dp[i][j][0] - prices[i]);
            }
        }

        return dp[n][k][0];
    }

    public static void main(String[] args) {
        Solution_5 solution = new Solution_5();
        int[] prices = {5, 3, 2, 1, 5};
        System.out.println(solution.method_1(1, prices));
        System.out.println(solution.method_2(1, prices));

    }
}
