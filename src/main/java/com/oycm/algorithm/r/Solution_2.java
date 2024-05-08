package com.oycm.algorithm.r;

import java.util.Arrays;

public class Solution_2 {

    /**
     * 322.零钱兑换
     * https://leetcode.cn/problems/coin-change/
     * @param coins
     * @param amount
     * @return
     */
    public int coinChange(int[] coins, int amount) {
        return 0;
    }

    // 计算错误
    public int method_1(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        dp[0][0] = 0;
        for (int j = 1; j <= amount; j++) {
            // 计算第一层的可兑换情况
            dp[0][j] = j % coins[0] == 0 ? j/coins[0] : Integer.MAX_VALUE;
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= amount; j++) {
                // 选了会超
                if (coins[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    int v = j / coins[i];
                    if (dp[i-1][j-v*coins[i]] == Integer.MAX_VALUE) {
                        dp[i][j] = Integer.MAX_VALUE;
                    }else {
                        // 这里表达式递推的有问题
                        dp[i][j] = Math.min(dp[i-1][j], dp[i-1][j-v*coins[i]]+v);
                    }

                }
            }
        }

        return dp[n-1][amount] == Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }

    // 正确递推写法
    public int method_2(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n+1][amount+1];
        // 表示个数为0时，都无法组成的amount
        Arrays.fill(dp[0], Integer.MAX_VALUE/2);
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= amount ; j++) {
                if (j < coins[i]) dp[i+1][j] = dp[i][j];
                else dp[i+1][j] = Math.min(dp[i][j], dp[i+1][j-coins[i]]+1);
            }
        }

        return dp[n][amount] >= Integer.MAX_VALUE/2 ? -1 : dp[n][amount];
    }

    // 优化空间复杂度
    public int method_3(int[] coins, int amount) {
        int n = coins.length;
        int[] dp = new int[amount+1];
        Arrays.fill(dp, Integer.MAX_VALUE/2);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            // 从前到后累加
            for (int j = coins[i]; j <= amount ; j++) {
                dp[j] = Math.min(dp[j], dp[j-coins[i]]+1);
            }
        }

        return dp[amount] >= Integer.MAX_VALUE/2 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] coins = {186,419,83,408};

        System.out.println(solution.method_1(coins, 6249));
        System.out.println(solution.method_2(coins, 6249));
        System.out.println(solution.method_3(coins, 6249));
    }
}
