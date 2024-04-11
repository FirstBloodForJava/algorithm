package com.oycm.algorithm.c;

/**
 * @author ouyangcm
 * create 2024/4/11 12:51
 */
public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums = {10,5,2,6};
        System.out.println(solution.numSubarrayProductLessThanK(nums, 100));
    }

    /**
     *
     * @param nums 正数的数组
     * @param k 给定的整数k
     * @return nums中严格小于k的连续子数组个数
     */
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        return method_1(nums, k);
    }

    /**
     * 暴力枚举的方式为从一个端点开始，nums[i]<k,则+1,继续先后枚举;nums[i]*nums[i+1]<k,则+1,继续向后枚举,直到乘积大于等于k或i+1直到nums.length-1 i端点的连续数组枚举完成
     *
     * @param nums
     * @param k
     * @return
     */
    public int method_1(int[] nums, int k){
        int result = 0;

        for (int i = 0; i < nums.length; i++) {
            int s = 1;
            for (int j = i; j < nums.length; j++) {
                s *= nums[j];
                if (s < k){
                    result++;
                }else {
                    break;
                }
            }
            // 或者在这里重置s
        }

        return result;
    }
}
