package com.oycm.algorithm.d;

public class Solution_2_35 {

    /**
     * 35.搜索插入位置: https://leetcode.cn/problems/search-insert-position/description/
     * @param nums 排序数组
     * @param target 目标值
     * @return 目标值在数组的索引,不存在则返回按顺序插入的位置
     */
    public int searchInsert(int[] nums, int target) {
        int ans = 0;
        // 在有序数组中寻找最后一个小于等于target的index,如果nums[index] == target,则返回index;否则返回index+1
        int left = -1;
        int right = nums.length;
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                left = mid;
                ans = left;
            }else {
                right = mid;
            }
        }

        return nums[ans] >= target ? ans : ans+1;
    }

    public static void main(String[] args) {
        Solution_2_35 solution = new Solution_2_35();
        int[] nums = {1, 2, 4, 5, 6, 9, 10};
        int target = 11;
        System.out.println(solution.searchInsert(nums, target));
    }
}
