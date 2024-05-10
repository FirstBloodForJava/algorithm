package com.oycm.algorithm.s;

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
                    // 注意是:dp[i-1][j-1]+1
                    dp[i][j] = Math.max(dp[i-1][j-1]+1, dp[i-1][j]);
                }
            }
        }

        return dp[n-1][m-1];
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        System.out.println(solution.method_1("abcba", "abcbcba"));

    }
}
