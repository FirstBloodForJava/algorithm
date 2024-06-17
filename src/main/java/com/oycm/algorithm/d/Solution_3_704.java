package com.oycm.algorithm.d;

public class Solution_3_704 {

    /**
     * 704.二分查找: https://leetcode.cn/problems/binary-search/description/
     * @param nums 升序数组
     * @param target 目标值
     * @return 目标值对于在数组的下标,不存在返回-1
     */
    public int search(int[] nums, int target) {
        int ans = -1;
        int left = -1;
        int right = nums.length;
        while (left+1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                ans = mid;
                break;
            }else if (nums[mid] < target){
                left = mid;
            }else {
                right = mid;
            }

        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_3_704 solution = new Solution_3_704();
        int[] nums = {-1,0,3,5,9,12};
        int target = 2;
        System.out.println(solution.search(nums, target));
    }
}
