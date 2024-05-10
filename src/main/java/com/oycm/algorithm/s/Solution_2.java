package com.oycm.algorithm.s;

import java.util.Arrays;

public class Solution_2 {

    /**
     * 72.编辑距离
     * https://leetcode.cn/problems/edit-distance/
     * @param word1
     * @param word2
     * @return
     */
    public int minDistance(String word1, String word2) {
        return 0;
    }

    private int method_1(String word1, String word2) {
        return dfs_1(word1.toCharArray(), word2.toCharArray(), word1.length()-1, word2.length()-1);
    }

    private int dfs_1(char[] t, char[] s, int i, int j) {
        if (i < 0) {
            return j+1;
        }
        if (j < 0) {
            return i+1;
        }
        if (t[i] == s[j]) {
            return dfs_1(t, s, i-1, j-1);
        } else {
            return Math.min(Math.min(dfs_1(t, s, i-1, j), dfs_1(t, s, i, j-1)), dfs_1(t, s, i-1, j-1)) + 1;
        }
    }

    private int method_2(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        return dfs_1(word1.toCharArray(), word2.toCharArray(), word1.length()-1, word2.length()-1, dp);
    }

    private int dfs_1(char[] t, char[] s, int i, int j, int[][] dp) {
        if (i < 0) {
            return j+1;
        }
        if (j < 0) {
            return i+1;
        }
        if (dp[i][j] != -1) {
            return dp[i][j];
        }
        if (t[i] == s[j]) {
            dp[i][j] = dfs_1(t, s, i-1, j-1, dp);
        } else {
            dp[i][j] = Math.min(Math.min(dfs_1(t, s, i-1, j, dp), dfs_1(t, s, i, j-1, dp)), dfs_1(t, s, i-1, j-1, dp)) + 1;
        }
        return dp[i][j];
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.method_1("intention", "execution"));
        System.out.println(solution.method_2("intention", "execution"));
    }
}
