package com.oycm.algorithm.a;

import java.util.Arrays;

/**
 * @author ouyangcm
 * create 2024/4/1 15:35
 */
public class Solution_2 {

    /**
     * 167.两数之和II-输入有序数组：https://leetcode.cn/problems/two-sum-ii-input-array-is-sorted/description
     * @param numbers
     * @param target
     * @return
     */
    public int[] twoSum(int[] numbers, int target) {
        return method_1(numbers,target);
    }

    public static int[] method_1(int[] nums, int target){
        int[] result = new int[2];
        Arrays.sort(nums);

        // 对于一个已经排序好的数组
        // 如果nums[0] + nums[length-1] > target,则任意nums[n] + nums[length-1] > target(n不为length-1,n>=0),意味着nums[length-1]和谁组合都会>target
        // 如果nums[0] + nums[length-1] < target,则任意nums[0] + nums[n] < target(n不为0,<length),意味着nums[0]和谁组合都会<target
        // 推理可得: 0<= i < j <= length-1
        // 如果nums[i] + nums[j] > target 则对nums[i] + nums[j-1] 和target比较
        // 如果nums[i] + nums[j] < target 则对nums[i+1] + nums[j] 和target比较
        // 知道和与target相等
        int i = 0;
        int j = nums.length -1;
        while (true){
            if ((nums[i] + nums[j]) > target){
                j--;
            }else if ((nums[i] + nums[j]) < target){
                i++;
            }else {
                break;
            }

        }
        result[0] = i + 1;
        result[1] = j + 1;
        return result;
    }
}
