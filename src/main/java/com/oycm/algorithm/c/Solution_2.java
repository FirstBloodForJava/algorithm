package com.oycm.algorithm.c;

/**
 * @author ouyangcm
 * create 2024/4/11 12:51
 */
public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums = {57, 44, 92, 28, 66, 60, 37, 33, 52, 38, 29, 76, 8, 75, 22};
        System.out.println(solution.numSubarrayProductLessThanK(nums, 18));
        System.out.println(solution.method_3(nums, 18));
        System.out.println(solution.method_2(nums, 18));
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
        while (right < nums.length){
            s *= nums[right];
            if (s < k){
                result++;
            }else {
                while (k <= s){
                    s = s / nums[left];
                    if (left == right){
                        left++;
                        break;
                    }
                    left++;
                    if (s < k){
                        result += right - left + 1;
                    }else {
                        result += right - left ;
                    }
                }
            }
            right++;
        }
        while (right == nums.length && left < right){
            left++;
            result += right - left;
        }
        return result;
    }

    /**
     * 端点二分法查找最后小于k的数组索引,逻辑支持，但是乘积太大会出现溢出导致计算不准确
     * @param nums
     * @param k
     * @return
     */
    public int method_3(int[] nums, int k){
        int result = 0;
        long[] s = new long[nums.length+1];
        s[0] = 1l;
        for (int i = 0; i < nums.length; i++) {
            s[i+1] = s[i] * nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int right = binarySearchLastMin(s, k * s[i]);
            if (right != -1){
                result += right - i;
            }
        }

        return result;
    }
    
    /**
     * 给定升序数组，找出最后一个小于x的索引,如果x < arr[0] 则返回 -1
     * @param arr 升序数组
     * @param x
     * @return
     */
    public int binarySearchLastMin(long[] arr, long x){
        int left = 0;
        int right = arr.length - 1;
        int result = arr.length;
        while (left <= right){
            int mid = (left + right) / 2;
            if (arr[mid] < x){
                result = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }
        }

        return result == arr.length ? -1 : result;
    }
}
