package com.oycm.algorithm.cd;

public class Solution_3_1358 {

    /**
     * 1358.包含所有三种字符的子字符串数目: https://leetcode.cn/problems/number-of-substrings-containing-all-three-characters/description/
     * @param s 只包含a, b, c三种字符串
     * @return a,b,c至少出现过一次的子字符串数目
     */
    public int numberOfSubstrings(String s) {
        int ans = 0;

        int n = s.length();
        char[] chars = s.toCharArray();

        int[] cache = new int['d'];
        int left = 0;
        for (int right = 0; right < n; right++) {
            cache[chars[right]]++;
            while (cache['a'] >= 1 && cache['b'] >= 1 && cache['c'] >= 1) {
                ans += n - right;
                cache[chars[left]]--;
                left++;
            }
        }

        return ans;
    }

    public static void main(String[] args) {

        String s = "abc";

        Solution_3_1358 solution = new Solution_3_1358();
        System.out.println(solution.numberOfSubstrings(s));

    }
}
