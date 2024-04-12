package com.oycm.algorithm.d;

public class Solution_1 {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        Solution_1 solution = new Solution_1();
        int[] result = solution.searchRange(nums, 8);
        System.out.println(solution.binarySearchFirstMax(nums, 8));
        System.out.println(solution.binarySearchLastMin(nums, 8));
        System.out.println(result[0] + ", " + result[1]);
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
     * @param nums
     * @param target
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
     * @param nums
     * @param target
     * @return
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

}
