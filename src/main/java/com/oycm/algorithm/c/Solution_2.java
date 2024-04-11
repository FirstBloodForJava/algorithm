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

    /**
     * 对于左端点left到right临界点，如果nums[left]*nums[left+1]*nums[right-1]*nums[right]<k,即再乘以nums[right+1]大于k,这里的连续数组数right-left+1
     * 则对于left+1端点到right点，必有nums[left+1]*nums[left+2]*nums[right-1]*nums[right]<k,这里不用比较的连续数组数时right-left
     * 这个时候如果right到右端点了，left还没有到，说明left到right的任意连续数组都满足小于k
     * @param nums
     * @param k
     * @return
     */
    public int method_2(int[] nums, int k) {
        int result = 0;
        int left = 0;
        int right = 0;
        int s = 1;
        for (int i = 0; i < nums.length; i++) {
            s *= nums[i];
            if (s < k) {
                result++;
            }else {
                left++;
                s = s / nums[left];
                result += right - left;
            }
        }


        return result;
    }
}
