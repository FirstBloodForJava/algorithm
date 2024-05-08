package com.oycm.algorithm.r;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_1 {

    /**
     * 494.目标和
     * https://leetcode.cn/problems/target-sum/
     * @param nums
     * @param target
     * @return
     */
    public int findTargetSumWays(int[] nums, int target) {
        return 1;
    }


    /**
     * dfs暴力解法
     * @param nums
     * @param target
     * @return
     */
    private int method_1(int[] nums, int target) {
        dfs_1(nums, target, 0);
        return count;
    }

    int count = 0;
    private void dfs_1(int[] nums, int target, int i) {
        if (nums.length == i) {
            if (target == 0) {
                count++;
            }
            return;
        }
        dfs_1(nums, target-nums[i],i+1);
        dfs_1(nums, target+nums[i],i+1);

    }

    private int method_1_1(int[] nums, int target) {
        for (int i : nums) {
            target += i;
        }
        if (target < 0 || target % 2 != 0) {
            return 0;
        }
        target /= 2;
        int[][] dp = new int[nums.length][target+1];
        return dfs_1(nums, target, nums.length-1, dp);
    }

    private int dfs_1(int[] nums, int target, int i, int[][] dp) {
        if (i < 0) {
            if (target == 0 ) return 1;
            return 0;
        }
        if (target < nums[i]) {
            dp[i][target] = dfs_1(nums, target, i-1, dp);
        }else {
            dp[i][target] = dfs_1(nums, target, i-1, dp) + dfs_1(nums, target-nums[i], i-1, dp);
        }
        return dp[i][target];
    }

    /**
     * 假设选为正数的和为: p
     * 假设nums的数组和为: s
     * 则选为负数正数和为: s-p
     * 则有: p - (s-p) = target
     * p = (s + target)/2,由于p是>=0(所选正数的和)的数，所有s+target肯定非负偶数
     * 所以问题转换成了：求选的正数和为p的组合数(方案数量)
     * 也可以理解为背包问题: 从[0-n]的物品中，物品价值为nums[i]选出物品价值总和等于target的组合数
     * 定义一个二维数组dp[i][j] i表示从[0-i]选任意数,使得和为j的对应的组合数
     * 当没有任何元素可以选取时，元素和只能是0，对应的方案数是1,这是为什么?也就是说p为0,不选任何数，都选负数，这个时候有一种方案
     * dp[0][0]=1 dp[0][j]=0(j>0)
     * 时间复杂度: O(n*(target+sum))
     * 空间复杂度: O(n*(target+sum))
     * @param nums 正数数组
     * @param target 目标和
     * @return 为目标和的所有组合数
     */
    public int method_2(int[] nums, int target) {
        for (int i : nums) {
            target += i;
        }
        if (target < 0 || target % 2 != 0) {
            return 0;
        }
        target /= 2;
        int n = nums.length;
        int[][] dp = new int[n+1][target+1];
        //
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] > j) {
                    dp[i+1][j] = dp[i][j];
                }else {
                    dp[i+1][j] = dp[i][j] + dp[i][j-nums[i]];
                }
            }
        }
        for (int[] ints : dp) {
            System.out.println(Arrays.stream(ints).mapToObj(i -> String.format("%2d", i)).collect(Collectors.joining(", ")));
        }
        return dp[n][target];
    }

    /**
     * 空间优化-1
     */
    public int method_3(int[] nums, int target) {
        for (int i : nums) {
            target += i;
        }
        if (target < 0 || target % 2 != 0) {
            return 0;
        }
        target /= 2;
        int n = nums.length;
        int[][] dp = new int[2][target+1];
        //
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= target; j++) {
                if (nums[i] > j) {
                    dp[(i+1)%2][j] = dp[i%2][j];
                }else {
                    dp[(i+1)%2][j] = dp[i%2][j] + dp[i%2][j-nums[i]];
                }
            }
        }

        return dp[n%2][target];
    }

    public int method_4(int[] nums, int target) {
        for (int i : nums) {
            target += i;
        }
        if (target < 0 || target % 2 != 0) {
            return 0;
        }
        target /= 2;
        int n = nums.length;
        int[] dp = new int[target+1];
        //
        dp[0] = 1;
        // 从大到小遍历，避免被覆盖
        for (int i = 0; i < n; i++) {
            for (int j = target; j >= 0; j--) {
                if (nums[i] <= j) {
                    dp[j] = dp[j] + dp[j-nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {1, 1, 1, 1, 1};
        /**
         *  dp[i][j] 从[0-1]选任意数，使得和为j的方案数dp[0][0]=1;dp[0][j>0]=0
         *  dp[i+1][j] = dp[i][j] + dp[i][j-nums[i]],从[0-i+1]中对应j可选的方案数为从[0-i][j]的方案数+[0-j][j-nums[i]]且j>=nums[i]
         *  0   1   2   3   4
         *  1,  0,  0,  0,  0
         *  1,  1,  0,  0,  0
         *  1,  2,  1,  0,  0
         *  1,  3,  3,  1,  0
         *  1,  4,  6,  4,  1
         *  1,  5, 10, 10,  5
         */
        System.out.println(solution.method_2(nums,3));
    }
}
