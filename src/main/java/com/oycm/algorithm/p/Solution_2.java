package com.oycm.algorithm.p;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution_2 {

    /**
     * 51.N皇后
     * https://leetcode.cn/problems/n-queens/
     * @param n
     * @return
     */
    public List<List<String>> solveNQueens(int n) {
        return null;
    }

    List<List<String>> ans = new ArrayList<>();
    List<Integer> path;
    int n;
    boolean[] onPath;
    boolean[] left;
    boolean[] right;
    List<Integer> stream = new ArrayList<>();

    private List<List<String>> method_1(int n) {
        this.n = n;
        onPath = new boolean[n];
        left = new boolean[2*n-1];
        right = new boolean[2*n-1];
        path = Arrays.asList(new Integer[n]);
        for (int i = 0; i < n; i++) {
            stream.add(i);
        }
        dfs_1(0);
        return ans;
    }
    private void dfs_1(int i) {
        if (i == n) {
            // 记录答案
            List<String> list = new ArrayList<>();
            for (Integer col : path) {
                list.add(stream.stream().map(x -> {
                    if (x.equals(col)) return "Q";
                    return ".";
                }).collect(Collectors.joining()));
            }
            ans.add(list);
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!onPath[j] && !left[i+j] && !right[i-j+n-1]) {
                path.set(i, j);
                onPath[j] = true;
                left[i+j] = right[i-j+n-1] = true;
                dfs_1(i+1);
                onPath[j] = false;
                left[i+j] = right[i-j+n-1] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.method_1(4));
    }
}
