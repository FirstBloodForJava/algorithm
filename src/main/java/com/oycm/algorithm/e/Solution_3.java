package com.oycm.algorithm.e;

public class Solution_3 {

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Solution_3 solution = new Solution_3();
        System.out.println(solution.search(nums, 0));
    }

    public int search(int[] nums, int target) {
        return method_1(nums, target);
    }

    public int method_1(int[] nums, int target) {
        int result = -1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > nums[nums.length-1]) {
                if (target >= nums[0] && target < nums[mid]) {
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target <= nums[nums.length-1] && target > nums[mid]) {
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }
        }

        return result;
    }
}
