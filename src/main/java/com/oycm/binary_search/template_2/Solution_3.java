package com.oycm.binary_search.template_2;

/**
 * @author ouyangcm
 * create 2024/4/8 12:41
 */
public class Solution_3 {

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        int[] nums = {3,4,5,1,2};
        System.out.println(solution.findMin(nums));
    }

    public int findMin(int[] nums) {

        return method_1(nums);
    }

    /**
     * 5 6 7 1 2 3 4 在这个数组中,旋转点两边的存在nums[n-1] < num[n]
     * @param nums
     * @return
     */
    public int method_1(int[] nums){
        if (nums.length == 1) {
            return nums[0];
        }
        int n = nums.length;
        int left = 0;
        int right = n - 1;
        int mid;
        while (left < right){
            mid = (left + right) / 2;
            if (nums[mid] > nums[n-1]){
                // 左边不可能有最小值
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return nums[right];
    }
}
