package com.oycm.algorithm.v;

import java.util.Arrays;

public class Solution_1 {

    /**
     * 516.最长回文子序列
     * https://leetcode.cn/problems/longest-palindromic-subsequence/
     * @param s
     * @return
     */
    public int longestPalindromeSubseq(String s) {
        return 0;
    }

    // 反转 + 最长公共子序列
    public int method_1(String s) {
        int n = s.length();
        char[] t = new char[s.length()];
        for (int i = 0; i < s.toCharArray().length; i++) {
            t[n-i-1] = s.charAt(i);
        }
        int[][] dp = new int[n][n];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(s.toCharArray(), t, n-1, n-1, dp);
    }
    public int dfs(char[] s, char[] t, int i, int j, int[][] dp) {
        if (i < 0 || j < 0) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (s[i] == t[j]) {
            dp[i][j] = dfs(s, t, i-1, j-1, dp) + 1;
        }else {
            dp[i][j] = Math.max(dfs(s, t, i-1, j, dp), dfs(s, t, i, j-1, dp));
        }
        return dp[i][j];
    }

    // 递推
    public int method_2(String s) {
        int n = s.length();
        char[] t = new char[s.length()];
        char[] ts = s.toCharArray();
        for (int i = 0; i < s.toCharArray().length; i++) {
            t[n-i-1] = ts[i];
        }
        int[][] dp = new int[n+1][n+1];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (ts[i] == t[j]) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                }else {
                    dp[i+1][j+1] = Math.max(dp[i][j+1], dp[i+1][j]);
                }
            }
        }

        return dp[n][n];
    }

    // 递推优化思路：单个数组加临时中间变量
    public int method_3(String s) {
        return 0;
    }

    // 递推，从两边到中间
    // dfs(i, j)
    // s[i] == s[j] dfs(i, j) = dfs(i+1, j-1) + 2
    // s[i] != s[j] dfs(i, j) = max(dfs(i+1, j), dfs(i, j-1))
    public int method_4(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs(s.toCharArray(), 0, s.length()-1, dp);
    }

    public int dfs(char[] s, int i, int j, int[][] dp) {
        if (i > j) return 0;
        if (i == j) return 1;
        if (dp[i][j] != -1) return dp[i][j];
        if (s[i] == s[j]) {
            dp[i][j] = dfs(s, i+1, j-1, dp) + 2;
        }else {
            dp[i][j] = Math.max(dfs(s, i+1, j, dp), dfs(s, i, j-1, dp));
        }
        return dp[i][j];
    }

    // 动态规划
    public int method_5(String s) {
        int n = s.length();
        char[] t = s.toCharArray();
        int[][] dp = new int[n][n];
        // dp[i][j] 表示在字符串下标内的，i到j之间的最长回文字串长度，0<=i<=j<n
        // 当i=j,自己就是回文串dp[i][j] = 1; 当i>j时，不可能组成字符串dp[i][j] = 0
        // 当i<j时,就需要考虑s[i]和s[j]相不相等的情况
        // s[i] == s[j], dp[i][j] = s[i+1][j-1] + 2
        // s[i] != s[j], dp[i][j] = max(s[i][j-1], s[i+1][j])中选最大
        // 怎么遍历的问题? 状态转移方程都是从长度较短的字符串到长度较长的字符串，要注意动态规划的顺序
        for (int i = n-1; i >=0 ; i--) {
            dp[i][i] = 1;
            for (int j = i+1; j < n; j++) {
                if (t[i] == t[j]) {
                    dp[i][j] = dp[i+1][j-1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i][j-1], dp[i+1][j]);
                }
            }
        }
        return dp[0][n-1];
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();

    }
}
