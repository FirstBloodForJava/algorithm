package com.oycm.algorithm.s;

import java.util.Arrays;

public class Solution_1 {

    /**
     * 1143.最长公共子序列
     * https://leetcode.cn/problems/longest-common-subsequence/
     * @param text1
     * @param text2
     * @return
     */
    public int longestCommonSubsequence(String text1, String text2) {
        return 1;
    }

    /**
     * dp[i][j] 二维数组，i范围[0,length(text1)]，j范围[0,length(text2)]
     * dp[i][j]的含义，表示text1[0,i]和text2[0,j]中这段文本的最长公共子序列
     * @param text1
     * @param text2
     * @return
     */
    private int method_1(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n][m];
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();
        if (t1[0] == t2[0]) dp[0][0] = 1;
        for (int j = 1; j < m ; j++) {
            if (t1[0] == t2[j]) {
                dp[0][j] = 1;
            }else {
                dp[0][j] = dp[0][j-1];
            }
        }
        for (int i = 1; i < n; i++) {
            if (t1[i] == t2[0]) {
                dp[i][0] = 1;
            }else {
                // 不相等继承上面的
                dp[i][0] = dp[i-1][0];
            }
            for (int j = 1; j < m; j++) {
                if (t1[i] != t2[j]) {
                    // 不相等
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }else {
                    // 注意是:dp[i-1][j-1]+1, 下面可以优化成 dp[i-1][j-1]+1,为什么能优化成这样
                    // 对于dp[i-1][j-1] 其LCS肯定是 <= dp[i-1][j] 或dp[i][j-1] 在这个二维数组里面，i-1的下面i，j-1的右边要j，对于的LCS都是>=x等于时+1这个最大，大于时也只会大1，所以不用比较
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                }
            }
        }

        return dp[n-1][m-1];
    }

    private int method_2(String text1, String text2) {
        return dfs_1(text1.toCharArray(), text2.toCharArray(), text1.length()-1, text2.length()-1);
    }

    private int dfs_1(char[] t, char[] s, int i, int j) {
        if (i < 0 || j < 0) return 0;
        if (t[i] == s[j]) {
            return dfs_1(t, s, i-1, j-1) + 1;
        }else {
            return Math.max(dfs_1(t, s, i-1, j), dfs_1(t, s, i, j-1));
        }
    }

    private int method_3(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs_1(text1.toCharArray(), text2.toCharArray(), text1.length()-1, text2.length()-1, dp);
    }
    private int dfs_1(char[] t, char[] s, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (t[i] == s[j]) {
            dp[i][j] = dfs_1(t, s, i-1, j-1, dp) + 1;
        }else {
            dp[i][j] = Math.max(dfs_1(t, s, i-1, j, dp), dfs_1(t, s, i, j-1, dp));
        }

        return dp[i][j];
    }

    private int method_4(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        int[][] dp = new int[n+1][m+1];
        char[] t1 = text1.toCharArray();
        char[] t2 = text2.toCharArray();

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= m; j++) {
                if (t1[i-1] == t2[j-1]) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[n][m];
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.method_1("abcba", "abcbcba"));
        System.out.println(solution.method_2("abcba", "abcbcba"));
        System.out.println(solution.method_3("abcba", "abcbcba"));
        System.out.println(solution.method_4("abcba", "abcbcba"));

    }
}
