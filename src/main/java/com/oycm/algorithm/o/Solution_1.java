package com.oycm.algorithm.o;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    int k;

    /**
     * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合
     * 77.组合
     * https://leetcode.cn/problems/combinations/
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        return null;
    }

    private List<List<Integer>> method_1(int n, int k) {
        this.k = k;
        dfs_1(n);
        return ans;
    }

    private void dfs_1(int i){
        // 还需要选d个数
        int d = k - path.size();
        if (d == 0) {
            // 记录答案
            ans.add(new ArrayList<>(path));
            return;
        }
        // 不选
        if (i > d) dfs_1(i-1);
        path.add(i);
        dfs_1(i-1);
        path.remove(path.size()-1);
    }
}
