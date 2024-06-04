package com.oycm.algorithm.cc;

/**
 * @author ouyangcm
 * create 2024/6/4 13:56
 */
public class Solution_1 {

    /**
     * 209.长度最小的子数组：https://leetcode.cn/problems/minimum-size-subarray-sum/description/
     * @param target
     * @param nums
     * @return
     */
    public int minSubArrayLen(int target, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int sum = 0;
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= target) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }

        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {2,3,1,2,4,3};
        int target = 7;
        System.out.println(solution.minSubArrayLen(target, nums));
    }
}
