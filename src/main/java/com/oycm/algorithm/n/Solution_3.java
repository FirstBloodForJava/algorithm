package com.oycm.algorithm.n;

import java.util.ArrayList;
import java.util.List;

public class Solution_3 {

    /**
     * 131.分割回文串:回文串是向前和向后读都相同的字符串，例如level，noon
     * https://leetcode.cn/problems/palindrome-partitioning/
     * @param s
     * @return
     */
    public List<List<String>> partition(String s) {
        return null;
    }

    List<List<String>> ans = new ArrayList<>();
    String s;
    List<String > path = new ArrayList<>();
    /**
     * s被分割成子集的所有情况，每个子集中所有子串都是回文串就是结果
     * 可以先找出字符串s分割成子集的情况
     * @param s
     * @return
     */
    public List<List<String>> method_1(String s) {
        this.s = s;
        dfs(0, 0);
        return ans;
    }

    private void dfs(int i, int start) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i < s.length()-1) dfs(i+1, start);

        if (isPalindrome(start, i)) {
            path.add(s.substring(start, i+1));
            dfs(i+1, i+1);
            path.remove(path.size()-1);
        }

    }

    /**
     * 字符串是否是回文字符串
     * @param left
     * @param right
     * @return
     */
    private boolean isPalindrome(int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

}
