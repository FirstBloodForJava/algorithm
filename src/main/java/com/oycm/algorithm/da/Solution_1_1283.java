package com.oycm.algorithm.da;

public class Solution_1_1283 {

    /**
     * 1283.使结果不超过阈值的最小除数: https://leetcode.cn/problems/find-the-smallest-divisor-given-a-threshold/
     * @param nums 整数数组
     * @param threshold 正整数阈值
     * @return 向上取整,选择一个正整数除数,使得所有元素除以它的和小于等于阈值的最小除数
     */
    public int smallestDivisor(int[] nums, int threshold) {
        int ans = 1;
        // 除数范围可为[1,无穷],题意的除数范围: [1,max(nums[i])],在这个范围内组成的阈值数组是非递增的
        // 这里的二分查找边界是什么? 第一个大于阈值+1就是答案
        int max = 0;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int left = 1;
        int right = max;
        // [left,right]是非递增数组,在这里面找第一个大于threshold的index,然后+1
        while (left < right) {
            int mid = left + (right - left) / 2;
            int tempThreshold = calculateNumsSum(nums, mid);
            // 为什么right不用mid-1,因为这里是半开半闭区间,只能一边移动
            if (tempThreshold <= threshold) {
                right = mid;
            }else {
                left = mid + 1;
                ans = left;
            }
        }

        return ans;
    }

    // 计算阈值
    public int calculateNumsSum(int[] nums, int divisor) {
        int ans = 0;
        for (int num : nums) {
            ans += (num + divisor -1) / divisor;
        }
        return ans;
    }

    // 找第一个大于target的索引
    public int binarySearchFirst(int[] nums, int target) {
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution_1_1283 solution = new Solution_1_1283();
        int[] nums = {2,3,5,7,11};
        int threshold = 11;
        System.out.println(solution.smallestDivisor(nums, threshold));
    }
}
