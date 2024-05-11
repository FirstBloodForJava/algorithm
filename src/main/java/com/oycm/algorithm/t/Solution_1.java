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


    public static int method() {
        int[] i = {1};
        ++i[0];
        return i[0]+1;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {4,10,4,3,8,9};
        System.out.println(solution.method_1(nums));
        System.out.println(solution.method_2(nums));

        System.out.println(method());
    }
}
