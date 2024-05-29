package com.oycm.algorithm.a;

import java.util.Arrays;

public class Solution_7 {

    /**
     * 时间复杂度 n*logn
     * 611.有效三角形的个数：https://leetcode.cn/problems/valid-triangle-number/description/
     * 给定一个数组nums,nums[i],nums[j],nums[k],且i != j != k,组成三角形的个数
     * a, b, c三条边组成三角形的条件:
     *  a + b > c
     *  a + c > b
     *  b + c > a 如果a <= b <= c,则只需要满足a+b > c即可
     * @param nums
     * @return
     */
    public int triangleNumber(int[] nums) {
        int ans = 0;
        // 1.排序
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 0; i < n-2; i++) {
            for (int j = i+1; j < n-1; j++) {
                // nums[i] + nums[j] > nums[k], k的范围(j,n),找最后一个小于target的索引 => 找第一个大于等于target的索引，结果-1就是小于target的最后一个索引
                ans += binarySearchFirst(nums, j, n, nums[i]+nums[j]) - j - 1;
            }
        }

        return ans;
    }

    /**
     *
     * @param nums 升序数组
     * @param left 左边界 不可取
     * @param right 有边界 不可取
     * @param target 目标值
     * @return 返回第一个大于等于target的索引，如果都小于target，return right
     */
    public int binarySearchFirst(int[] nums, int left, int right, int target) {
        while (left+1 < right) {
            int mid = (right + left) / 2;
            if (nums[mid] >= target) {
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

    public static void main(String[] args) {
        Solution_7 solution = new Solution_7();
        int[] nums = {4,2,3,4};
        System.out.println(solution.triangleNumber(nums));
    }
}
