package com.oycm.algorithm.da;

public class Solution_3_2871 {

    /**
     * 2871.将数组分割成最多数目的子数组: https://leetcode.cn/problems/split-array-into-maximum-number-of-subarrays/description/
     * @param nums 非负整数数组
     * @return 子数组分数: nums[l] | nums[l+1] ... nums[r] 与运算, 子数组分数尽可能小,返回最多可以得到多少个子数组
     */
    public int maxSubarrays(int[] nums) {
        int ans = 0;

        // i & j的结果肯定是小于等于min(i, j),所以当[0,n)的与运算结果大于0则意味着子数组只能是一个才能满足是子数组分数最小的条件(子数组的AND都是大于等于整个数组的AND)
        // 要想有更多的子数组,就需要满足任意连续子数组的分数都是0
        int s = nums[0];
        int left = 1;
        int right = nums.length;
        while (left < right) {
            if (s == 0) {
                ans++;
                s = nums[left];
            }else {
                s = s & nums[left];
            }

            left++;
        }
        if (s > 0 && ans == 0) return 1;
        if (s == 0) ans++;
        return ans;
    }

    public static void main(String[] args) {
        Solution_3_2871 solution = new Solution_3_2871();
        int[] nums = {1,0,2,0,1,2};
        System.out.println(solution.maxSubarrays(nums));
    }
}
