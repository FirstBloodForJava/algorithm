package com.oycm.algorithm.q;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * @author ouyangcm
 * create 2024/5/7 10:12
 */
public class Solution_2 {

    /**
     *
     * @param weight 第i个物品的体积
     * @param value 第i个物品的价值
     * @param c 背包容量
     * @return 对应背包容量下的所容量物品的最大价值
     */
    public int method_1(int[] weight, int[] value, int c) {
        return dfs_1(weight, value, weight.length-1, c);
    }

    private int dfs_1(int[] weight, int[] value, int i, int c) {
        if (i < 0) {
            return 0;
        }
        if (c < weight[i]) {
            // 容量不够
            i1++;
            return dfs_1(weight, value, i-1, c);
        }
        i1++;
        return Math.max(dfs_1(weight, value, i-1, c), dfs_1(weight, value, i-1, c-weight[i])+value[i]);

    }

    /**
     * 如何使用记忆集优化递归
     * @return
     */
    public int method_2(int[] weight, int[] value, int c) {
        // dp[i][j] 二维数组记录从下标[0-i]中选取任意取物品，放入容量为j的背包中，价值总和最大是多少
        int[][] dp = new int[weight.length][c+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int ans = dfs_2(weight, value, weight.length-1, c, dp);
        for (int[] ints : dp) {
            System.out.println(Arrays.stream(ints).mapToObj(i -> String.format("%2d", i)).collect(Collectors.joining(", ")));
        }
        return ans;
    }
    int i1 = 0;
    int i2 = 0;

    private int dfs_2(int[] weight, int[] value ,int i, int c, int[][] dp) {
        if (i < 0 || c == 0) return 0;

        if (dp[i][c] != -1) {
            return dp[i][c];
        }

        if (c < weight[i]) {
            dp[i][c] = dfs_2(weight, value, i-1, c, dp);
        }else {
            dp[i][c] = Math.max(dfs_2(weight, value, i-1, c, dp), dfs_2(weight, value, i-1, c-weight[i], dp)+value[i]);
        }
        i2++;
        return dp[i][c];
    }

    /**
     * 动态规划：定义一个二维数组，dp[i][j]，含义是从下标[0-i]中任意选取物品，放入容量为j的背包中，价值总和最大值
     * 动态规划方程：dp[i][j] = max(dp[i-1][j], dp[i-1][j-weight[i]] + value[i])
     * 时间复杂度nxc,n表示物品的个数，c表示背包的容量
     * 空间复杂度nxc
     * @return
     */
    public int method_3(int[] weight, int[] value, int c) {
        int[][] dp = new int[weight.length][c+1];
        // 初始化dp[0][j]的容量
        for (int j = weight[0]; j <= c; j++){
            dp[0][j] = value[0];
        }
        for (int i = 1; i < weight.length; i++) {
            for (int j = 0; j <= c; j++) {
                if (j < weight[i]) {
                    // 容量不够，上一层对应容量即这一层对应最大容量
                    dp[i][j] = dp[i-1][j];
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                }
            }
        }

        return dp[weight.length-1][c];
    }

    public static void main(String[] args) {
        int[] weight = {1, 2, 3};
        int[] value = {6, 10, 12};
        Solution_2 solution = new Solution_2();
        System.out.println(solution.method_1(weight, value, 5));
        System.out.println(solution.method_2(weight, value, 5));
        System.out.println(solution.method_3(weight, value, 5));

        System.out.println(solution.i1);
        System.out.println(solution.i2);
    }

}
