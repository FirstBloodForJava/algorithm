package com.oycm.algorithm.v;

import java.util.Arrays;

public class Solution_2 {

    /**
     * 1039.多边形三角剖分的最低得分
     * https://leetcode.cn/problems/minimum-score-triangulation-of-polygon/
     * @param values
     * @return
     */
    public int minScoreTriangulation(int[] values) {
        return 0;
    }

    public int method_1(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(0, n-1, values, dp);
    }

    // dp[i][j] 表示顶点i顺时针到顶点j
    public int dfs(int i, int j, int[] values, int[][] dp) {
        if (i+1 == j) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        int temp = Integer.MAX_VALUE;
        for (int k = i+1; k < j; k++) {
            temp = Math.min(temp, dfs(i, k, values, dp) + dfs(k, j, values, dp) + values[i]*values[j]*values[k]);
        }
        dp[i][j] = temp;
        return dp[i][j];
    }


    public int method_2(int[] values) {
        int n = values.length;
        int[][] dp = new int[n][n];
        for (int i = n-3; i >= 0; i--) {
            for (int j = i+2; j < n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int k = i+1; k < j; k++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j] + values[i]*values[j]*values[k]);
                }

            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] values = {1,3,1,4,1,5};
        System.out.println(solution.method_1(values));
        System.out.println(solution.method_2(values));

    }
}
