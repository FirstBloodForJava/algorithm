package com.oycm.algorithm.cd;

public class Solution_2_713 {

    /**
     * 713.乘积小于K的子数组：https://leetcode.cn/problems/subarray-product-less-than-k/description/
     * @param nums
     * @param k
     * @return 乘积小于k的连续子数组个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int ans = 0;
        if (k <= 1) return ans;
        int left = 0;

        // 乘积
        int m = 1;

        for (int right = 0; right < nums.length; right++) {
            m *= nums[right];
            // k > 1的,当m==1时，left = right+1
            while (m >= k) {
                m /= nums[left];
                left++;
            }
            // 计算连续子数组,固定右端点计算连续子数组: [left,right]之间的连续子数组,[left,right] [left+1,right] ... [right,right],就是left到right之间的端点数
            ans += right - left + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_2_713 solution = new Solution_2_713();
        int[] nums = {1, 5, 2, 6};
        int k = 0;
        System.out.println(solution.numSubarrayProductLessThanK(nums, k));
    }
}
