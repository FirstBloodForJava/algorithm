package com.oycm.binary_search.template_1;

// 搜索旋转排序数组
public class Solution_3 {

    public static void main(String[] args) {
        int[] ints = new int[]{1,3};
        System.out.println(method_1(ints, 1));
    }

    public static int search(int[] nums, int target) {

        return method_1(nums, target);
    }

    // [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]],k（0 <= k < nums.length） 则数组也有可能是未旋转的

    public static int method_1(int[] nums, int target){
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid = 0;
        if (n == 1){
            return nums[0] == target ? 0 : -1;
        }
        while (left <= right){
            mid = (left + right) / 2;

            if (nums[mid] == target){
                return mid;
            }
            // mid落在旋转点前一段
            if (nums[mid] >= nums[0]){
                if (target >= nums[0] && target < nums[mid]){
                    right = mid - 1;
                }else {
                    left = mid + 1;
                }
            }else {
                if (target <= nums[n-1] && target > nums[mid]){
                    left = mid + 1;
                }else {
                    right = mid - 1;
                }
            }

        }

        return -1;
    }


}
