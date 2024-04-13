package com.oycm.algorithm.d;

public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        Solution_1 solution = new Solution_1();
        int[] result1 = solution.searchRange(nums, 8);
        int[] result2 = solution.method_2(nums, 8);
        System.out.println(solution.binarySearchFirstMax(nums, 8));
        System.out.println(solution.binarySearchLastMin(nums, 8));
        System.out.println(result1[0] + ", " + result1[1]);
        System.out.println(result2[0] + ", " + result2[1]);
    }

    /**
     *
     * @param nums 升序数组
     * @param target 目标值
     * @return 目标值在元素中出现的开始位置
     */
    public int[] searchRange(int[] nums, int target) {
        return method_1(nums, target);
    }

    /**
     * left即第一个大于等于target的index
     * right即最后一个小于等于target的index
     * @param nums
     * @param target
     * @return
     */
    public int[] method_1(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums.length == 0){
            return result;
        }
        int l = binarySearchFirstMax(nums, target);
        int r = binarySearchLastMin(nums, target);
        if ((l == r && nums[r] == target) || (l != r && nums[l] == nums[r] && nums[l] == target)){
            result[0] = l;
            result[1] = r;
        }

        return result;
    }

    /**
     * 第一个>=target的index
     * @param nums 升序数组
     * @param target 目标值
     * @return nums.length-1可能不满足nums[length-1] >= target
     */
    public int binarySearchFirstMax(int[] nums, int target) {
        int result = nums.length - 1;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right + left) / 2;
            if (nums[mid] >= target) {
                result = mid;
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return result;
    }

    /**
     * 最后一个<=target的index
     * @param nums 升序数组
     * @param target 目标值
     * @return 0 可能 nums[0] > target
     */
    public int binarySearchLastMin(int[] nums, int target) {
        int result = 0;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result;
    }

    public int[] method_2(int[] nums, int target) {
        int[] result = {-1,-1};
        if (nums.length == 0){
            return result;
        }
        int left = searchFirstMax(nums, target, true);
        int right = searchFirstMax(nums, target, false) - 1;
        if (left <= right && right < nums.length && nums[left] == target && nums[right] == target){
            result[0] = left;
            result[1] = right;
        }

        return result;
    }

    /**
     *  升序数组查找第一个大于或大于等于target的index
     * @param nums 升序数组
     * @param target 搜索大于的目标值
     * @param flag true 大于等于target的 false 表示大于target
     * @return 满足返回index，不满足则返回nums.length
     */
    public int searchFirstMax(int[] nums, int target, boolean flag) {
        int result = nums.length;
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] > target || (flag && nums[mid] >= target)) {
                result = mid;
                // nums[mid] > target 则[mid,right]肯定>target
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return result;
    }

}
