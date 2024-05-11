package com.oycm.algorithm.t;

public class Solution_1 {


    /**
     * 300.最长递增子序列
     * https://leetcode.cn/problems/longest-increasing-subsequence/
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        return 1;
    }

    private int method_1(int[] nums) {
        int n = nums.length;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, i);
        }
        return ans;
    }

    private int dfs(int[] nums, int i) {
        if (i == 0) {
            return 1;
        }
        for (int j = 0; j < i; j++) {

        }
        return 0;
    }

    private int method_2(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];

        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= n; j++) {

            }
        }
        return dp[n][n];

    }



    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {4,10,4,3,8,9};
        System.out.println(solution.method_1(nums));

    }
}
