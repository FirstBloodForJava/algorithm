package com.oycm.algorithm.db;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ouyangcm
 * create 2024/6/19 16:49
 */
public class Solution_6_2861 {

    /**
     * 2861.最大合金数: https://leetcode.cn/problems/maximum-number-of-alloys/
     * @param n 不同类型的金属
     * @param k 机器数
     * @param budget 金额预算
     * @param composition 二维数组,[i][j]标识第i台机器创建合金需要composition[i][j]份j类型金属
     * @param stock 一维数组,标识开始拥有的stock[i]份i类型金属
     * @param cost 一维数组,标识购入一份i类型金属花费的cost[i]金钱
     * @return 不超过budget前提下,最大化公司制造的合金数量(所有合金需要由同一台机器制造)
     * composition.length  == k
     * composition[i].length == n
     * stock.length == cost.length == n
     * 时间复杂度 O(lg2*10^8 * n * k)
     */
    public int maxNumberOfAlloys(int n, int k, int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost) {
        int ans = 0;

        // 假设我能制造x块合金，则一定可以构造x-1块合金,二分查找不超过预算所能制造的合金数max(x)
        int left = 0;
        int right = 200000000;
        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (isBuild(budget, composition, stock, cost, mid)) {
                ans = mid;
                left = mid + 1;
            }else {
                right = mid - 1;
            }

        }

        return ans;
    }
    public boolean isBuild(int budget, List<List<Integer>> composition, List<Integer> stock, List<Integer> cost, long x) {

        for (List<Integer> amount : composition) {
            long charge = 0;
            for (int i = 0; i < amount.size(); i++) {
                charge += cost.get(i) * (amount.get(i) * x - stock.get(i));
            }
            if (charge <= budget) return true;
        }


        return false;
    }

    public static void main(String[] args) {

        Solution_6_2861 solution = new Solution_6_2861();

        int n = 3;
        int k = 2;
        int budget = 15;
        List<List<Integer>> composition = new ArrayList<>();

        List<Integer> j1 = new ArrayList<>();
        j1.add(1);
        j1.add(1);
        j1.add(1);
        composition.add(j1);
        List<Integer> j2 = new ArrayList<>();
        j2.add(1);
        j2.add(1);
        j2.add(10);
        composition.add(j2);

        List<Integer> stock = new ArrayList<>();
        stock.add(0);
        stock.add(0);
        stock.add(0);

        List<Integer> cost = new ArrayList<>();
        cost.add(1);
        cost.add(2);
        cost.add(3);

        System.out.println(solution.maxNumberOfAlloys(n, k, budget, composition, stock, cost));
    }
}
