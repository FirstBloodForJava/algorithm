package com.oycm.algorithm.e;

public class Solution_2 {

    public static void main(String[] args) {
        int[] nums = {2, 1};
        Solution_2 solution = new Solution_2();
        System.out.println(solution.findMin(nums));
    }

    public int findMin(int[] nums) {
        return method_1(nums);
    }

    /**
     * 区间内保留2个元素
     * @param nums
     * @return
     */
    public int method_1(int[] nums) {
        int n = nums.length;
        if (nums[0] <= nums[n-1]) {
            return nums[0];
        }
        int left = 0;
        int right = n - 1;
        while (left+1 < right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[0]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return Math.min(nums[left], nums[right]);
    }
}
