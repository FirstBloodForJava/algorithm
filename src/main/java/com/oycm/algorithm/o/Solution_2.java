package com.oycm.algorithm.o;

import java.util.ArrayList;
import java.util.List;

public class Solution_2 {

    /**
     * 216.组合总和 III
     * https://leetcode.cn/problems/combination-sum-iii/
     * @param k
     * @param n
     * @return
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        return null;
    }

    List<List<Integer>> ans_1 = new ArrayList<>();
    List<Integer> path_1 = new ArrayList<>();
    int k1;

    /**
     * 递归过程中用t记录n-i
     * 剪枝条件：
     * 1.剩余数字不够i < d
     * 2.t < 0
     * 3.t > 全部选最大的情况，(1+n)*n/2 = (i + (i-d+1) ) * d / 2
     * @param k
     * @param n
     * @return
     */
    private List<List<Integer>> method_1(int k, int n) {
        this.k1 = k;
        dfs_1(9, n);
        return ans_1;
    }

    private void dfs_1(int i, int t) {
        int d = k1 - path_1.size();
        if (t < 0 || t > (i*d + (1-d)*d/2)) {
            return;
        }
        if (k1 == path_1.size()) {
            ans_1.add(new ArrayList<>(path_1));
            return;
        }

        for (int j = i; j >= d ; j--) {
            path_1.add(j);
            dfs_1(j-1, t-j);
            path_1.remove(path_1.size()-1);
        }
    }

    List<List<Integer>> ans_2 = new ArrayList<>();
    List<Integer> path_2 = new ArrayList<>();
    int k2;

    /**
     * 选/不选
     * @param k
     * @param n
     */
    private List<List<Integer>> method_2(int k, int n) {
        this.k2 = k;
        dfs_2(9, n);
        return ans_2;
    }

    private void dfs_2(int i, int t) {
        int d = k2 - path_2.size();

        if (t < 0 || t > (i*d + (1-d)*d/2)) {
            return;
        }

        if (d == 0) {
            ans_2.add(new ArrayList<>(path_2));
            return;
        }

        // 不选
        if (d < i) {
            dfs_2(i-1, t);
        }
        // 选
        path_2.add(i);
        dfs_2(i-1, t-i);
        path_2.remove(path_2.size()-1);
    }
}
