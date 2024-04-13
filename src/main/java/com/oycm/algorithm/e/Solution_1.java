package com.oycm.algorithm.e;

public class Solution_1 {

    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        Solution_1 solution = new Solution_1();
        System.out.println(solution.findPeakElement(nums));
        System.out.println(solution.method_2(nums));
    }

    /**
     *
     * @param nums
     * @return
     */
    public int findPeakElement(int[] nums) {
        return method_1(nums);
    }

    public int method_1(int[] nums) {
        if (nums.length == 1){
            return 0;
        }
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (compare(nums, mid-1, mid) < 0 && compare(nums, mid, mid +1) > 0) {
                return mid;
            }
            if (compare(nums,mid-1,mid) > 0){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }

    /**
     *
     * @param nums
     * @param index
     * @return
     */
    public int[] getValue(int[] nums, int index) {
        int[] result = {0,0};
        if (index == -1 || index == nums.length) {
            return result;
        }
        result[0] = 1;
        result[1] = nums[index];

        return result;
    }

    /**
     *
     * @param nums
     * @param left
     * @param right
     * @return nums[left]>nums[right] 1
     */
    public int compare(int[] nums, int left, int right) {
        int[] leftV = getValue(nums, left);
        int[] rightV = getValue(nums, right);
        if (leftV[0] != rightV[0]) {
            return leftV[0] > rightV[0] ? 1: -1;
        }
        return leftV[1] > rightV[1] ? 1 : -1;
    }

    /**
     * 当nums[mid] > nums[mid+1],符合条件的肯定是在左边，所以right=mid,直到left+1<right退出循环
     * @param nums
     * @return 峰值
     */
    public int method_2(int[] nums) {
        int left = -1;
        int right = nums.length - 1;
        while (left+1 < right){
            int mid = (right - left) / 2 + left;
            if (nums[mid] > nums[mid+1]) {
                right = mid;
            }else {
                left = mid;
            }
        }
        return right;
    }

}
