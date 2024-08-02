package com.oycm.algorithm.db;

import java.util.PriorityQueue;

/**
 * @author ouyangcm
 * create 2024/6/19 16:29
 */
public class Solution_5_1642 {

    /**
     * 1642.可以到达的最远建筑: https://leetcode.cn/problems/furthest-building-you-can-reach/
     * 当前建筑物高度大于或等于下一个建筑高度,不需要使用梯子或砖块
     * 当前建筑物的高度小于下一个建筑高度,可以使用一架梯子或(h[i+1]-h[i])个砖块
     * @param heights 表示建筑物的高度, eg: {4,2,7,6,9,14,12}
     * @param bricks 砖块; eg: 5
     * @param ladders 梯子; eg: 1
     * @return 最佳方式移动到的最远建筑物下标 4
     * 时间复杂度 O(n) 空间复杂度lgn
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans = 0;
        // 思路: 当剩余的砖块支持达到到达下一个建筑物，优先使用砖块；当砖块不够使用时，剩余梯子大于0，则可以挑选前面最大的高度差，来消耗一次梯子，剩余砖块数量+最大高度差，梯子剩余数量-1
        // 直到梯子为0，剩余砖块小于当前下标高度差。
        // 砖块不够时，可以通过每次遍历都去寻找最大的高度差
        // 思路转换: 固定一个diff，大于等于diff的
        int n = heights.length;
        if (ladders >= n-1) return n - 1;

        // 构造一个优先队列,最大堆
        PriorityQueue<Integer> queue = new PriorityQueue<>((x, y) -> y.compareTo(x));
        for (int i = 0; i < n-1; i++) {
            int diffH = heights[i+1] - heights[i];
            if (diffH > 0) {
                // 记录高度
                queue.add(diffH);
                // 使用砖块
                bricks -= diffH;

                // 砖块不够了，梯子也不够，当前即能到达的最远距离
                if (bricks < 0 && ladders <= 0) {
                    return i;
                }
                // 前面没有return，即梯子数量大于0或砖块大于等于0
                // 这里等于0不能替换使用梯子，因为可能后面的diffH可能会大于之前的使用的梯子
                if (bricks < 0) {
                    int maxDiffH = queue.poll();
                    bricks += maxDiffH;
                    ladders--;
                }

            }
            ans = i + 1;
        }

        return ans;
    }

    public static void main(String[] args) {

        Solution_5_1642 solution = new Solution_5_1642();

        int[] heights = {2,7,9,12};
        int bricks = 5;
        int ladders = 1;

        System.out.println(solution.furthestBuilding(heights, bricks, ladders));

    }
}
