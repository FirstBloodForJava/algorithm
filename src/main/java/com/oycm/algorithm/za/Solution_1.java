package com.oycm.algorithm.za;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class Solution_1 {

    /**
     * 239.滑动窗口最大值
     * https://leetcode.cn/problems/sliding-window-maximum/description/
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        return nums;
    }

    public int[] method_1(int[] nums, int k) {
        if (k == 1) return nums;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // deque 单调递减
        for (int i = 0; i < n; i++) {
            // 1.入队列: 构建单调递减的队列(从左到右)
            while (!deque.isEmpty() && nums[i] >= nums[deque.getLast()]) {
                deque.removeLast();
            }
            deque.addLast(i);

            // 2.出队列 范围是[i-k+1, i], 所以 i - k + 1 > 队列的头
            if (i - deque.getFirst() > k -1 ) deque.removeFirst();

            // 3.记录答案
            if (i - k + 1 >=0) ans[i-k+1] = nums[deque.getFirst()];
        }
        return ans;
    }

    public int[] method_2(int[] nums, int k) {
        if (k == 1) return nums;
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        Deque<Integer> deque = new LinkedList<>();
        // deque 单调递增(从左到右)
        for (int i = 0; i < n; i++) {
            // 1.构建队列
            while (!deque.isEmpty() && nums[i] >= nums[deque.getFirst()]){
                deque.removeFirst();
            }
            deque.addFirst(i);

            // 2.出队列
            if (i - deque.getLast() > k -1) deque.removeLast();

            // 3.记录答案
            if (i - k + 1 >= 0) ans[i-k+1] = nums[deque.getLast()];
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        int[] nums = {1,3,-1,-3,5,3,6,7};
        int k = 3;
        System.out.println(Arrays.toString(solution.method_1(nums, k)));
        System.out.println(Arrays.toString(solution.method_2(nums, k)));
    }
}
