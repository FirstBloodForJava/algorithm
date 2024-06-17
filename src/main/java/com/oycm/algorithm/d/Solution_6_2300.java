package com.oycm.algorithm.d;

import java.util.Arrays;
import java.util.stream.Collectors;

public class Solution_6_2300 {

    /**
     * 2300.咒语和药水的成功对数: https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/
     * @param spells 表示第i个诅咒的能量强度
     * @param potions 表示第j瓶药水的能量强度
     * @param success 诅咒的能力强度*药水的能力强度 >= success，表示一堆成功的组合
     * @return 第i个诅咒成功组合
     */
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ans = new int[spells.length];

        // 对药水进行排序处理
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            ans[i] = potions.length - binarySearchFirst(potions, spells[i], success);
        }

        return ans;
    }

    public int binarySearchFirst(int[] potions, long multiple, long target) {
        int left = 0;
        int right = potions.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] * multiple >= target) {
                right = mid;
            }else {
                left = mid + 1;
            }

        }
        return right;
    }

    public static void main(String[] args) {
        int[] spells = {3,1,2};
        int[] potions = {8,5,8};
        long success = 16;
        Solution_6_2300 solution = new Solution_6_2300();
        System.out.println(Arrays.stream(solution.successfulPairs(spells, potions, success)).mapToObj(String::valueOf).collect(Collectors.joining(",", "[", "]")));

    }
}
