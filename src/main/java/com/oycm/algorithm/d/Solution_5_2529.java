package com.oycm.algorithm.d;

public class Solution_5_2529 {

    /**
     * 2529.正整数和负整数的最大计数: https://leetcode.cn/problems/maximum-count-of-positive-integer-and-negative-integer/description/
     * @param nums 非递减数组
     * @return 正整数计数和负整数计数两者的最大值
     */
    public int maximumCount(int[] nums) {

        // 正整数个数: nums.length - 第一个大于0的index(都小于等于0返回nums.length)
        // 负整数个数: 第一个大于等于0的index
        // 转换成了在nums中查找第一个和0相关的索引
        int pos = nums.length - binarySearchFirst(nums, 0, false);
        int neg = binarySearchFirst(nums, 0, true);

        return Math.max(pos, neg);
    }

    public int binarySearchFirst(int[] nums, int target, boolean isEquals) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target || (isEquals && nums[mid] == target)) {
                right = mid;
            }else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        Solution_5_2529 solution = new Solution_5_2529();
        int[] nums = {-2,-1,-1,1,2,3};
        System.out.println(solution.maximumCount(nums));
    }
}
