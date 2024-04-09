package com.oycm.binary_search.template_3;

/**
 * @author ouyangcm
 * create 2024/4/9 9:34
 */
public class Solution_1 {

    public static void main(String[] args) {
        int[] nums = {1, 3, 10};
        Solution_1 solution = new Solution_1();
        int[] m1 = solution.searchRange(nums, 11);
        int[] m2 = solution.method_2(nums, 11);
        System.out.println(m1[0] + " " + m1[1]);
        System.out.println(m2[0] + " " + m2[1]);

    }

    public int[] searchRange(int[] nums, int target) {
        return method_1(nums, target);
    }

    /**
     * 1, 2, 3, 4, 5, 6
     * 记录第一次出现的left,right
     * 后续出现的就为right
     * @param nums 已排序升序数组
     * @param target 目标值
     * @return 找出
     */
    public int[] method_1 (int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int n = nums.length;

        if (n == 0){
            return result;
        }

        if (target < nums[0] || target > nums[n-1]) {
            return result;
        }
        int start = -1;
        int end = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == target && start == -1){
                start = i;
                end = i;
            }else if (nums[i] == target){
                end = i;
            }
        }
        result[0] = start;
        result[1] = end;
        return result;
    }

    /**
     * 利用排序二分查找
     * 找target出现的开始位置，意味着找第一个等于target的索引，记为leftInx
     * 找target出现的结束位置，意味着找第一个大于target的索引-1，记为rightInx
     * 找leftInx意味着找出第一个大于等于target的索引
     * 找rightInx意味着找出第一个大于target的索引，然后-1
     * 索引可能对应不等于target,还需要校验
     * @param nums
     * @param target
     * @return
     */
    public int[] method_2(int[] nums, int target) {
        int[] result = new int[]{-1, -1};
        int n = nums.length;

        if (n == 0){
            return result;
        }

        int leftInx = binarySearch(nums, target, true);
        int rightInx = binarySearch(nums, target, false) - 1;
        if (leftInx <= rightInx && rightInx < n && nums[leftInx] == target && nums[rightInx] == target){
            return new int[]{leftInx, rightInx};
        }

        return result;
    }


    /**
     *
     * @param nums 升序数组
     * @param target 目标值
     * @param low true 大于等于; false 大于
     * @return
     */
    public int binarySearch(int[] nums, int target, boolean low) {
        int left = 0;
        int right = nums.length - 1;
        // 边界-1
        int result = nums.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (nums[mid] > target || (low && nums[mid] >= target)){
                right = mid - 1;
                result = mid;
            }else {
                left = mid + 1;
            }
        }

        return result;
    }

}
