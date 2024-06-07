package com.oycm.algorithm.cc;

public class Solution_3 {

    /**
     * 1574.删除最短的子数组使剩余数组有序：https://leetcode.cn/problems/shortest-subarray-to-be-removed-to-make-array-sorted/
     * @param arr
     * @return 返回删除最短连续的子数组长度，使得剩余数组是非递减的
     */
    public int findLengthOfShortestSubarray(int[] arr) {
        int n = arr.length;
        if (n <= 1) return 0;
        int ans = n-1;

        return ans;
    }
}
