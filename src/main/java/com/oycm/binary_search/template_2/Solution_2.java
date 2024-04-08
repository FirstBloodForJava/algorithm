package com.oycm.binary_search.template_2;

import java.util.Stack;

/**
 * @author ouyangcm 寻找峰值
 * create 2024/4/8 12:42
 */
public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums = {1, 2, 7, 6, 8};
        System.out.println(solution.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        return method_2(nums);
    }

    /**
     * 单调栈找出 数组中大于左右相邻的下标, 当前下标i不满足,则意味这nums[i] < nums[i+1] 则下一个nums[i+1]只需要判断是否大于nums[i+2]
     * @param nums
     * @return
     */
    public int method_1(int[] nums){
        if (nums.length == 1){
            return 0;
        }

        Stack<Integer> stack = new Stack<>();
        int temp = 0;
        while (temp < nums.length){
            if (stack.isEmpty()){
                stack.push(temp);
            }else {
                if (nums[stack.peek()] > nums[temp]){
                    return stack.pop();
                }else {
                    stack.pop();
                    stack.push(temp);
                }
            }
            temp++;
        }

        if (!stack.isEmpty()){
            return stack.pop();
        }

        return -1;
    }

    /**
     * nums[i] < nums[i+1] 意味着 nums[i+1]和nums[i+2]比较,
     * 如果nums[i+1]大于nums[i+2],直接return就可以了
     * 如果nums[i+1]小于nums[i+2],则开始用i+2进行后续比较 用result记录i+1
     * @param nums
     * @return
     */
    public int method_2(int[] nums){
        int result = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[result] < nums[i]){
                result = i;
            }else {
                return result;
            }
        }

        return result;
    }
}
