package com.oycm.algorithm.z;

import java.util.Stack;

public class Solution_2 {

    /**
     * 42.接雨水
     * https://leetcode.cn/problems/trapping-rain-water/
     * @param height
     * @return
     */
    public int trap(int[] height) {
        // 利用单调栈，计算横向能接多少水
        Stack<Integer> stack = new Stack<>();
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            // 栈中还有元素，且大于等于栈顶元素，保证栈顶到栈底是单调递增的(底到顶是单调递减的)
            while (!stack.isEmpty() && height[i] >= height[stack.peek()]) {
                // 栈顶的高
                Integer pop = stack.pop();
                if (stack.isEmpty()) {
                    // 没有下一个元素，不能接水
                    break;
                }
                // 栈顶下一个元素的高
                Integer left = stack.peek();
                int h = Math.min(height[left], height[i]) - height[pop];
                int w = i - left - 1;
                ans += h * w;
            }
            stack.push(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(solution.trap(height));
    }
}
