package com.oycm.algorithm.q;

/**
 * @author ouyangcm
 * create 2024/5/7 10:12
 */
public class Solution_2 {

    /**
     *
     * @param weight 第i个物品的体积
     * @param value 第i个物品的价值
     * @param c 背包容量
     * @return 对应背包容量下的所容量物品的最大价值
     */
    public int method_1(int[] weight, int[] value, int c) {
        return dfs(weight, value, weight.length-1, c);
    }

    private int dfs(int[] weight, int[] value, int i, int c) {
        if (i < 0) {
            return 0;
        }
        if (c < weight[i]) {
            // 容量不够
            return dfs(weight, value, i-1, c);
        }
        return Math.max(dfs(weight, value, i-1, c), dfs(weight, value, i-1, c-weight[i])+value[i]);

    }

}
