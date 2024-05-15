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

    // 边界条件 dfs(i, k, flag)
    // dfs(*, -1, *) = 负无穷; dp[i][0][flag] = min
    // dfs(-1, *, 0) = 0;      dp[0][k][0] = 0  (k>=1)
    // dfs(-1, *, 1) = 负无穷; dp[0][k][1] = min (k>=1)
    // i: [0, n]; k: [0, k+1]
    public int method_3(int k, int[] prices) {
        // 递推实现
        int min = -10000000;
        int n = prices.length;
        int[][][] dp = new int[n+1][k+2][2];

        // 次数边界初始化
        for (int i = 0; i <= n; i++) {
            dp[i][0][0] = min;
            dp[i][0][1] = min;
        }

        // 股票持有边界初始化 [0][k][1] k>=1 负无穷
        for (int i = 1; i < k+2; i++) {
            dp[0][i][1] = min;
        }
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < k+2; j++) {
                dp[i+1][j][0] = Math.max(dp[i][j][0], dp[i][j-1][1] + prices[i]);
                dp[i+1][j][1] = Math.max(dp[i][j][1], dp[i][j][0] - prices[i]);
            }
        }

        return dp[n][k+1][0];
    }

    // 递推+空间优化
    public int method_4(int k, int[] prices) {
        int min = -10000000;
        int[][] dp = new int[k+2][2];
        // 初始化dp[0][k][flag]
        for (int i = 0; i < k+2; i++) {
            if (i == 0) {
                dp[i][0] = min;
            }
            dp[i][1] = min;

        }

        // 下一层只使用上一层的元素，但是k+1修改之后会被k+2使用到，所以倒叙遍历
        for (int i = 0; i < prices.length; i++) {
            for (int j = k+1; j >0 ; j--) {
                dp[j][0] = Math.max(dp[j][0], dp[j-1][1] + prices[i]);
                dp[j][1] = Math.max(dp[j][1], dp[j][0] - prices[i]);
            }
        }

        return dp[k+1][0];
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        int[] prices = {3, 2, 6, 5, 0, 3};
        System.out.println(solution.method_1(2, prices));
        System.out.println(solution.method_2(2, prices));
        System.out.println(solution.method_3(2, prices));
        System.out.println(solution.method_4(2, prices));
    }
}
