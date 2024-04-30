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
     * 假设字符串s的两个字符之间都有一个,aab->a,a,b，有','代表选，无','代表不选，有以下几种情况
     * [aab] 都不选
     * [a,ab] 选第一个，不选第二个
     * [aa,b] 不选第一个，选第二个
     * [a,b,c] 都选
     * @param s
     * @return
     */
    public List<List<String>> method_1(String s) {
        this.s = s;
        dfs_1(0, 0);
        return ans;
    }

    private void dfs_1(int i, int start) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }

        if (i < s.length()-1) dfs_1(i+1, start);

        if (isPalindrome(start, i)) {
            path.add(s.substring(start, i+1));
            dfs_1(i+1, i+1);
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

    /**
     * 答案视角，回溯三问：
     * 1.当前操作？选择回文字串s[i..j]，加入path
     * 2.子问题？从下标>=i的后缀中构造回文分割
     * 3.下一个子问题？从下标>=j+1的后缀中构造回文分割
     * @param s
     * @return
     */
    public List<List<String>> method_2(String s) {
        this.s = s;
        dfs_2(0);
        return ans;
    }

    private void dfs_2(int i) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        // 枚举子串
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(i, j)) {
                path.add(s.substring(i, j+1));
                dfs_2(j+1);
                path.remove(path.size()-1);
            }
        }
    }

    private boolean isPalindrome(String s, int left, int right) {
        while (left < right) {
            if (s.charAt(left++) != s.charAt(right--)) return false;
        }
        return true;
    }

    private void dfs_2_1(String s, int i, List<List<String>> ans, List<String> path) {
        if (i == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (isPalindrome(s, i, j)) {
                path.add(s.substring(i, j+1));
                dfs_2_1(s,j+1, ans, path);
                path.remove(path.size()-1);
            }
        }
    }

}
