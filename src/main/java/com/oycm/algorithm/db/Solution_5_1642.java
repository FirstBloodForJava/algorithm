package com.oycm.algorithm.db;

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
     */
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        int ans = 0;
        // 思路: 当剩余的砖块支持达到到达下一个建筑物，优先使用砖块；当砖块不够使用时，剩余梯子大于0，则可以挑选前面最大的高度差，来消耗一次梯子，剩余砖块数量+最大高度差，梯子剩余数量-1
        // 直到梯子为0，剩余砖块小于当前下标高度差。
        // 砖块不够时，可以通过每次遍历都去寻找最大的高度差
        // 思路转换: 固定一个diff，大于等于diff的

        return ans;
    }
}
