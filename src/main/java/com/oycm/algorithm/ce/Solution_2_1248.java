package com.oycm.algorithm.ce;

import java.util.ArrayDeque;
import java.util.Deque;

public class Solution_2_1248 {

    /**
     * 优美子数组: 连续子数组的奇数个数恰好是k个
     * 1248.统计[优美子数组]https://leetcode.cn/problems/count-number-of-nice-subarrays/
     * @param nums 整数数组
     * @param k 目标值
     * @return 优美子数组的个数
     */
    public int numberOfSubarrays(int[] nums, int k) {
        int ans = 0;

        // 题目和930类似,这里的奇数相当于是1,偶数默认0;k相当于goal,但是k是>=1的
        int temp = 0;
        int leftLength = 1;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int right = 0; right < nums.length; right++) {
            queue.add(right);
            if (nums[right] % 2 == 1) {
                temp++;
            }
            while (temp > k) {
                queue.removeFirst();
                leftLength = 1;
                temp--;
            }
            if (temp == k) {
                // 记录答案
                while (nums[queue.getFirst()] % 2 != 1){
                    leftLength++;
                    queue.removeFirst();
                }
                ans += leftLength;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_2_1248 solution = new Solution_2_1248();
        int[] nums = {2,2,2,1,2,2,1,2,2,2};
        int k = 2;
        System.out.println(solution.numberOfSubarrays(nums, k));
    }
}
