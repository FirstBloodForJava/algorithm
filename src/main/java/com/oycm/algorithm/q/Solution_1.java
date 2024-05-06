package com.oycm.algorithm.q;

import java.util.Arrays;

public class Solution_1 {

    /**
     * 动态规划
     * 198.打家劫舍
     * https://leetcode.cn/problems/house-robber/description/
     * 每个房间的最高总金额只和该房屋的金额和前两间房间的最高总金额相关。f0表示第i-2间最高总金额，f1表示第i-1间最高总金额
     * @param nums
     * @return
     */
    public int rob(int[] nums) {
        int f0 = 0, f1 = 0;
        for (int num : nums) {
            int temp = f1;
            f1 = Math.max(num+f0, f1);
            f0 = temp;
        }
        return f1;
    }

    /**
     * 直接使用递归，时间超出，时间复杂度2^n
     *
     * @param nums
     * @return
     */
    private int method_1(int[] nums) {
        return dfs_1(nums, nums.length-1);
    }

    private int dfs_1(int[] nums, int i) {
        if (i < 0) return 0;
        return Math.max(dfs_1(nums, i-1), dfs_1(nums, i-2) + nums[i]);
    }

    /**
     * 时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @return
     */
    private int method_2(int[] nums) {
        int[] cache = new int[nums.length];
        Arrays.fill(cache, -1);
        return dfs_2(nums, cache, nums.length-1);
    }
    private int dfs_2(int[] nums, int[] cache, int i) {
        if (i < 0) return 0;
        if (cache[i] != -1) return cache[i];
        // 记录缓存
        cache[i] = Math.max(dfs_2(nums, cache, i-1), dfs_2(nums, cache, i-2) + nums[i]);
        return cache[i];
    }

    /**
     * 递推：时间复杂度O(n),空间复杂度O(n)
     * @param nums
     * @return
     */
    private int method_3(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+2];
        for (int i = 0; i < n; i++) {
            dp[i+2] = Math.max(dp[i]+nums[i], dp[i+1]);
        }

        return dp[n+1];
    }


    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240};
        long start = System.currentTimeMillis();
        //System.out.println(solution.method_1(nums) + " ," + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        System.out.println(solution.method_2(nums) + " ," + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        System.out.println(solution.method_3(nums) + " ," + (System.currentTimeMillis()-start));

        start = System.currentTimeMillis();
        System.out.println(solution.rob(nums) + " ," + (System.currentTimeMillis()-start));
    }
}
