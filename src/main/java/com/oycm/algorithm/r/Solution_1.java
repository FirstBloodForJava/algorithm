package com.oycm.algorithm.r;

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

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {1, 1, 1, 1, 1};
        System.out.println(solution.method_1(nums,3));
    }
}
