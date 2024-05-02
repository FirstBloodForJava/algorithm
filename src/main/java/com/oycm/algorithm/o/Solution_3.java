package com.oycm.algorithm.o;

import java.util.ArrayList;
import java.util.List;

public class Solution_3 {

    /**
     * 22.括号生成
     * https://leetcode.cn/problems/generate-parentheses/
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        return null;
    }

    List<String> ans = new ArrayList<>();
    char[] path;
    int m;
    int n;

    /**
     * 选n个位置放'(',选了'('就不能选')',2n的结构中选n个'('和n')'
     * '(' 数量 left < n就能选左括号
     * ')' 数量 i=left+right right < left;right=i-left,即i-left < left,右括号数量小于左括号数量就可以选右括号
     * @param n
     * @return
     */
    private List<String> method_1(int n) {
        this.m = 2*n;
        this.n = n;
        path = new char[m];
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int left) {
        // 记录答案
        if (i == m) {
            ans.add(new String(path));
            return;
        }
        if (left < n) {
            path[i] = '(';
            dfs(i+1, left+1);
        }
        if (i-left < left) {
            path[i] = ')';
            dfs(i+1, left);
        }

    }
}
