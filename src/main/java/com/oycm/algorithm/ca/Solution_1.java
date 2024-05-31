package com.oycm.algorithm.ca;

public class Solution_1 {

    /**
     * 1456.定长子串中元音的最大数目: https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/description/
     * 字符串s和整数k,返回长度为k的单个子字符串中最大元音字母数
     * 元音字母: a, e, i, o, u
     * @param s
     * @param k
     * @return
     */
    public int maxVowels(String s, int k) {
        int ans = 0;
        int[] tempCache = new int[s.length()];

        char[] charArray = s.toCharArray();
        int temp = 0;
        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == 'a' || charArray[i] == 'e' || charArray[i] == 'i' || charArray[i] == 'o' || charArray[i] == 'u') {
                temp++;
                tempCache[i] = 1;
            }
            if (i >= k) {
                temp -= tempCache[i-k];
            }
            ans = Math.max(ans, temp);
            if (ans == k) break;
        }

        return ans;
    }

    public static void main(String[] args) {

    }
}
