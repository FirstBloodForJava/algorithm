package com.oycm.algorithm.z;

import java.util.Stack;

public class Solution_1 {

    /**
     * 739.每日温度
     * 整数数组 temperatures 表示每天的温度, 返回一个数组answer,其中answer[i]是指对于第i天,下一个更高温度出现在几天后
     * 如果气温在这之后都不会升高，请在该位置用0来代替
     * https://leetcode.cn/problems/daily-temperatures/
     * @param temperatures
     * @return
     */
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();

        // 使用栈，从右到左
        for (int i = n-1; i >= 0; i--) {
            // 弹出小于当前天温度的元素
            while (!stack.isEmpty() && temperatures[i] >= temperatures[stack.peek()]) {
                stack.pop();
            }
            // 栈不为空，代表栈中有大于当前稳定的某天
            if (!stack.isEmpty()) {
                answer[i] = stack.peek() - i;
            }
            stack.push(i);
        }
        return answer;
    }

    // 从左到右
    public int[] method_2(int[] temperatures) {
        int n = temperatures.length;
        int[] answer = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            // 找到之前栈中的最大温度
            while (!stack.isEmpty() && temperatures[i] > temperatures[stack.peek()]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            stack.push(i);
        }

        return answer;
    }
}
