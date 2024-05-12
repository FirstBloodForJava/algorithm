package com.oycm.algorithm.t;

import java.util.Arrays;

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
            ans = Math.max(ans, dfs(nums, i));
        }
        return ans;
    }

    private int dfs(int[] nums, int i) {
        int res = 0;

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                res = Math.max(res, dfs(nums, j));
            }
        }
        return res + 1;
    }

    private int method_2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int ans = 0;
        for (int i = 0; i < n ; i++) {
            ans = Math.max(ans, dfs(nums, i, dp));
        }
        return ans;

    }
    private int dfs(int[] nums, int i, int[] dp) {
        if (dp[i] > 0) return dp[i];

        for (int j = 0; j < i; j++) {
            if (nums[j] < nums[i]) {
                dp[i] = Math.max(dp[i], dfs(nums, j, dp));
            }
        }

        return ++dp[i];
    }

    // 选/不选
    private int method_1_1(int[] nums) {

        return dfs(nums, nums.length-1, nums.length);
    }
    private int dfs(int[] nums, int i, int pre) {
        if (i < 0) return 0;

        if (pre == nums.length || nums[i] < nums[pre]) {
            return Math.max(dfs(nums, i-1, i) + 1, dfs(nums, i-1, pre));
        }
        return dfs(nums, i-1, pre);

    }

    // 记忆化搜索
    private int method_2_1(int[] nums) {
        int[][] dp = new int[nums.length][nums.length+1];
        for (int[] ints : dp) {
            Arrays.fill(ints, -1);
        }
        int ans = dfs(nums, nums.length-1, nums.length, dp);
        return ans;
    }

    private int dfs(int[] nums, int i, int pre, int[][] dp) {
        if (i < 0) return 0;
        if (dp[i][pre] != -1) return dp[i][pre];
        if (pre == nums.length || nums[i] < nums[pre]) {
            dp[i][pre] = Math.max(dfs(nums, i-1, i, dp) + 1, dfs(nums, i-1, pre, dp));
        }else {
            dp[i][pre] = dfs(nums, i-1, pre, dp);
        }
        return dp[i][pre];
    }


    public static int method() {
        int[] i = {1};
        ++i[0];
        // return 3
        return i[0]+1;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {4,5,1,2,10,4,3,8,9};
        System.out.println(solution.method_1(nums));
        System.out.println(solution.method_2(nums));
        System.out.println(solution.method_1_1(nums));
        System.out.println(solution.method_2_1(nums));

    }
}
