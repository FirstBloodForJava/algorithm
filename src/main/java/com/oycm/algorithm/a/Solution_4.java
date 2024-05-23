package com.oycm.algorithm.a;

import java.util.Arrays;

public class Solution_4 {


    /**
     * 16.最接近的三数之和：https://leetcode.cn/problems/3sum-closest/description/
     * @param nums
     * @param target
     * @return
     */
    public int threeSumClosest(int[] nums, int target) {
        return 0;
    }

    /**
     * 暴力解法
     * @param nums
     * @param target
     * @return
     */
    public int method_1(int[] nums, int target) {
        int n = nums.length;
        if (n == 3) return nums[0] + nums[1] + nums[2];
        int ans = Integer.MAX_VALUE / 2;

        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                for (int k = j+1; k < n; k++) {
                    int temp = nums[i] + nums[j] + nums[k];
                    if (Math.abs(temp-target) < Math.abs(ans-target)) ans = temp;
                }
            }
        }

        return ans;
    }

    /**
     * 时间复杂度优化：优化思路——类似有序数组的求三数之和nums[i] + nums[j] + nums[k] = target, 固定nums[i]+nums[k] 在(i,k)之间找target-nums[i]-nums[k] = nums[j]
     * 最接近的三数之和，转换成了求：固定nums[i]+nums[k] 在(i,k)之间找|target-nums[i]-nums[k] - nums[j]|的最小绝对值
     *
     * @param nums
     * @param target
     * @return
     */
    public int method_2(int[] nums, int target) {
        int n = nums.length;
        if (n == 3) return nums[0] + nums[1] + nums[2];
        int ans = Integer.MAX_VALUE / 2;
        Arrays.sort(nums);
        for (int i = 0; i < n-2; i++) {
            int j = i + 1;
            int k = n - 1;
            while (j < k) {
                int temp = nums[i] + nums[j] + nums[k];
                if (temp > target) {
                    k--;
                }else {
                    j++;
                }
                ans = Math.abs(temp-target) > Math.abs(ans-target) ? ans : temp;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {-1,2,1,-4};
        int target = 1;
        Solution_4 solution = new Solution_4();

        System.out.println(solution.method_1(nums, target));
        System.out.println(solution.method_2(nums, target));
    }
}
