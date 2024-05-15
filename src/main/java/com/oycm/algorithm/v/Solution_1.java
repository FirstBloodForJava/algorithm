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
}
