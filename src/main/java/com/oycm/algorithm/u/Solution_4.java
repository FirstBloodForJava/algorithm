package com.oycm.algorithm.u;

import java.util.Arrays;

/**
 * @author ouyangcm
 * create 2024/5/15 10:17
 */
public class Solution_4 {

    int min = -10000000;
    /**
     * 恰好交易k次的最大收益
     * @param k 交易k次
     * @param prices 股票每天的价格
     * @return
     */
    public int equalsProfit(int k, int[] prices) {
        return 1;
    }

    public int method_1(int k, int[] prices) {
        if (k <= 0 ) return 0;
        // 交易次数比股票的天数/2还大
        if (k >= prices.length/2 + 1) return 0;
        return dfs(k, prices.length-1, 0, prices);
    }

    public int dfs(int k, int i, int flag, int[] prices){
        // k < 0 不合法
        if (k < 0 ) {
            return min;
        }
        if (i < 0) {
            if (k > 0 || flag == 1) {
                return min;
            }else {
                return 0;
            }
        }
        if (flag == 1) {
            return Math.max(dfs(k, i-1, 1, prices), dfs(k-1, i-1, 0, prices) - prices[i]);
        }
        return Math.max(dfs(k, i-1, 0, prices), dfs(k, i-1, 1, prices) + prices[i]);
    }

    // 递推实现
    public int method_2(int k, int[] prices) {
        int min = -1000000;
        if (k <= 0 ) return 0;
        // 交易次数比股票的天数/2还大
        if (k >= prices.length/2 + 1) return 0;
        int n = prices.length;
        int[][][] dp = new int[n+1][k+2][2];
        // 初始化
        // dp[i][0][0] = min
        // dp[0][k][f] = min (k>=1)
        // dp[0][1][0] = 0;
        // dp[0][1][1] = min;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k+2; j++) {
                Arrays.fill(dp[i][j], min);
            }
        }
        dp[0][1][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k+2; j++) {
                dp[i+1][j][0] = Math.max(dp[i][j][0], dp[i][j-1][1] + prices[i]);
                dp[i+1][j][1] = Math.max(dp[i][j][1], dp[i][j][0] - prices[i]);
            }
        }

        return dp[n][k+1][0];
    }

    public static void main(String[] args) {
        Solution_4 solution = new Solution_4();
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.method_1(2, prices));
        System.out.println(solution.method_2(2, prices));
    }
}
