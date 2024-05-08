package com.oycm.algorithm.q;

import java.util.Arrays;

/**
 * @author ouyangcm
 * 0-1完全背包 动态规划方程推导
 * 背包容量: target
 * 物品的体积: weight[i]
 * 物品的价值: value[i]
 * 每种物品可以重复选
 * 计算：所选物品体积不超过容量target的情况下，所得到的的最大价值和
 * create 2024/5/8 10:04
 */
public class Solution_3 {

    // 回溯
    public int method_1(int[] weight, int[] value, int target) {

        return dfs_1(weight, value, target, weight.length-1);
    }

    private int dfs_1(int[] weight, int[] value, int target, int i) {
        if (i < 0 || target <= 0) return 0;
        if (weight[i] > target) {
            return dfs_1(weight, value, target, i-1);
        }else {
            return Math.max(dfs_1(weight, value, target, i-1), dfs_1(weight, value, target-weight[i], i)+value[i]);
        }

    }

    // 回溯+记忆化搜索
    public int method_2(int[] weight, int[] value, int target) {
        int[][] dp = new int[weight.length][target+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int ans = dfs_2(weight, value, target, weight.length - 1, dp);
        return ans;
    }
    private int dfs_2(int[] weight, int[] value, int target, int i, int[][] dp) {
        if (i < 0 || target == 0) return 0;
        if (dp[i][target] != -1) {
            return dp[i][target];
        }
        if (weight[i] > target) {
            dp[i][target] = dfs_2(weight, value, target, i-1, dp);
        }else {
            dp[i][target] = Math.max(dfs_2(weight, value, target, i-1, dp), dfs_2(weight, value, target-weight[i], i, dp)+value[i]);
        }
        return dp[i][target];
    }

    // 递推 递推公式错误 dp[i][j] = max(dp[i-1][j], dp[i][j-weight[i]]+value[i])
    public int method_3(int[] weight, int[] value, int target) {
        int n = weight.length;
        int[][] dp = new int[n][target+1];
        // 初始化dp[0][j] j范围[0-target]的最大体积情况
        for (int j = weight[0]; j <= target; j++) {
            if (j % weight[0] == 0) {
                dp[0][j] =  dp[0][j-1] + value[0];
            }else {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (weight[i] > j) {
                    dp[i][j] = dp[i-1][j];
                }else {
                    // 解决多选的问题
                    int v = j / weight[i];
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-weight[i]]+value[i]);
                }
            }
        }

        return dp[n-1][target];
    }

    public int method_4(int[] weight, int[] value, int target) {
        int n = weight.length;
        int[] dp = new int[target+1];
        for (int j = weight[0]; j <= target; j++) {
            int v = j / weight[0];
            dp[j] = value[0] * v;
        }
        for (int i = 1; i < n; i++) {
            for (int j = target; j >= 0; j--) {
                if (weight[i] <= j) {
                    // 解决多选的问题
                    dp[j] = Math.max(dp[j], dp[j-weight[i]] + value[i]);
                }
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        int[] weight = {1, 2};
        int[] value = {2, 2};
        int target = 5;
        System.out.println(solution.method_1(weight, value, target));
        System.out.println(solution.method_2(weight, value, target));
        System.out.println(solution.method_3(weight, value, target));
        System.out.println(solution.method_4(weight, value, target));
    }
}
