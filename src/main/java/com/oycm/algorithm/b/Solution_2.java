package com.oycm.algorithm.b;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author ouyangcm
 * create 2024/4/3 11:01
 */
public class Solution_2 {
    public static void main(String[] args) {
        int[] ints = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(trap(ints));
    }

    /**
     * 42.接雨水：https://leetcode.cn/problems/trapping-rain-water/description/
     * @param height
     * @return
     */
    public static int trap(int[] height) {

        return method_4(height);
    }

    // 动态规划 前缀和
    public static int method_1(int[] height){
        if (height.length <= 1){
            return 0;
        }
        int result = 0;

        int[] leftHeight = new int[height.length];
        leftHeight[0] = height[0];
        // 计算i左边的最高点
        for (int i = 1; i < height.length; i++) {
            leftHeight[i] = Math.max(height[i], leftHeight[i-1]);
        }
        // 计算i右边的最高点
        int[] rightHeight = new int[height.length];
        rightHeight[height.length-1] = height[height.length-1];
        for (int i = height.length-2; i >=0 ; i--) {
            rightHeight[i] = Math.max(height[i], rightHeight[i+1]);
        }
        // 两个端点是计不上的
        for (int i = 1; i < height.length-1; i++) {
            result += Math.min(leftHeight[i], rightHeight[i]) - height[i];
        }

        return result;
    }

    // 双指针: 计算每个下标i能接多少雨水
    public static int method_2(int[] height){
        int result = 0;
        int leftMax = 0;
        int rightMax = 0;
        int left = 0;
        int right = height.length-1;
        while (left < right){
            leftMax = Math.max(leftMax, height[left]);
            rightMax = Math.max(rightMax, height[right]);
            if (leftMax < rightMax){
                // 计算并且指针右移
                result += leftMax - height[left];
                left++;
            }else {
                result += rightMax - height[right];
                right--;
            }
        }

        return result;
    }

    // 单调栈错误代码
    public static int method_3(int[] height){
        int result = 0;
        int[] nextMax = new int[height.length];
        Arrays.fill(nextMax, 0);
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]){
                nextMax[stack.pop()] = height[i];
            }
            stack.push(i);
        }

        int leftMax = 0;
        for (int i = 0; i < height.length; i++) {
            leftMax = Math.max(leftMax, height[i]);
            result += Math.min(leftMax, nextMax[i] == 0 ? height[i] : nextMax[i]) - height[i];
        }


        return result;
    }

    // 栈: 先进后出,后进先出
    // 这里的栈: 从栈顶到栈底是递增,节水的条件是要形成盆地: 下坡再上坡
    // 单调栈: 计算情况:栈中至少要有两个元素才能和当前的高围成一个盆地
    public static int method_4(int[] height){
        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            // 栈里面有低点，当高度高于前面的低点
            while (!stack.isEmpty() && height[i] > height[stack.peek()]){
                int top = stack.pop();
                // 栈内至少要有两个元素,一个元素的情况时,后面的高度一直在上升
                if (stack.isEmpty()) {
                    break;
                }
                int left = stack.peek();
                int currWidth = i - left - 1;
                int currHeight = Math.min(height[left], height[i]) - height[top];
                result += currHeight * currWidth;
            }
            stack.push(i);
        }

        return result;
    }

}
