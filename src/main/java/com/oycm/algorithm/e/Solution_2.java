package com.oycm.algorithm.e;

public class Solution_2 {

    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        Solution_2 solution = new Solution_2();
        System.out.println(solution.findMin(nums));
        System.out.println(solution.method_2(nums));
        System.out.println(solution.method_3(nums));
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

    public int method_2(int[] nums) {
        int left = -1;
        int right = nums.length - 1;
        while (left+1 <right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < nums[nums.length-1]) {
                right = mid;
            }else {
                left = mid;
            }
        }
        return nums[right];
    }

    public int method_3(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[nums.length-1]){
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return nums[left];
    }
}
