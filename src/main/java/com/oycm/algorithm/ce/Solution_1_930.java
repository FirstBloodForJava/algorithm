package com.oycm.algorithm.ce;

import java.util.Deque;
import java.util.LinkedList;

public class Solution_1_930 {

    /**
     * 930.和相同的二元子数组: https://leetcode.cn/problems/binary-subarrays-with-sum/description/
     * @param nums 二元子数组(不是1就是0)
     * @param goal 目标值
     * @return 和为目标值的子数组(连续子数组)
     */
    public int numSubarraysWithSum(int[] nums, int goal) {
        int ans = 0;
        // [left,right]数组和为goal,则left左边为0的和right右边为0的
        int n = nums.length;

        int left = 0;

        if (goal == 0) {
            for (int right = 0; right < n; right++) {
                if (nums[right] == 1) {
                    //ans += right - left; 这里不记录答案
                    left = right + 1;
                }else {
                    ans += right - left + 1;
                }
            }
        }else {
            int temp = 0;
            Deque<Integer> queue = new LinkedList<>();
            int leftLength = 1;
            for (int right = 0; right < n; right++) {
                temp += nums[right];
                queue.add(right);
                if (temp > goal) {
                    queue.removeFirst();
                    leftLength = 1;
                    temp--;
                }
                if (temp == goal) {
                    while (nums[queue.getFirst()] != 1) {
                        queue.removeFirst();
                        leftLength++;
                    }
                    ans += leftLength;
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_1_930 solution = new Solution_1_930();
        int[] nums = {0,0,0,0,0,0,1,0,0,0};
        int goal = 0;
        System.out.println(solution.numSubarraysWithSum(nums, goal));
    }
}
