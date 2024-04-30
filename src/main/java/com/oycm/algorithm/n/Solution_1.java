package com.oycm.algorithm.n;

import java.util.ArrayList;
import java.util.List;

public class Solution_1 {

    /**
     * 17.电话号码的字母组合
     * https://leetcode.cn/problems/letter-combinations-of-a-phone-number/
     * @param digits
     * @return
     */
    public List<String> letterCombinations(String digits) {
        return null;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        List<String> ans = solution.method_1("4");
        System.out.println(ans);
        System.out.println(ans.size());
    }

    List<String> ans = new ArrayList<>();
    private static final char[][] MAPPING = {{}, {}, {'a', 'b', 'c'}, {'d', 'e', 'f'}, {'g', 'h', 'i'}, {'j', 'k', 'l'}, {'m', 'n', 'o'}, {'p', 'q', 'r', 's'}, {'t', 'u', 'v'}, {'w', 'x', 'y', 'z'}};

    /**
     * 原问题：根据给定的字符串数组情况，返回其对应下字符组合对应长度的字符串
     * 子问题：
     * @param digits [2-9]之间数组组合的字符串，与电话按键相同的字符组合长度，对应数组下的字母组合情况
     * @return
     */
    public List<String> method_1(String digits) {
        if (digits.length() == 0) return ans;

        char[] charArray = digits.toCharArray();
        dfs(charArray,0, new char[digits.length()]);
        return ans;
    }

    private void dfs(char[] digits, int i, char[] result) {
        if (i == digits.length) {
            ans.add(new String(result));
            return;
        }
        char[] temp = MAPPING[Integer.parseInt(String.valueOf(digits[i]))];
        for (int j = 0; j < temp.length; j++) {
            result[i] = temp[j];
            dfs(digits, i+1, result);
        }

    }
}
