package com.oycm.algorithm.a;

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
}
