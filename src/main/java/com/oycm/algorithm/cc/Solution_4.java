package com.oycm.algorithm.cc;

public class Solution_4 {

    /**
     * 76.最小覆盖子串：https://leetcode.cn/problems/minimum-window-substring/
     * @param s
     * @param t
     * @return s的最小字串：需要包含t所有字符的(顺序没有要求，相同数量保持一致)
     */
    public String minWindow(String s, String t) {
        int n = s.length();
        String ans = "";
        if (n < t.length()) {
            return ans;
        }
        // 1.统计t中每个字母出现的次数countT
        int[] countT = new int[128];
        for (char c : t.toCharArray()) {
            ++countT[c];
        }

        // 初始化 ansLeft = -1, ansRight = s.length
        int ansLeft = -1;
        int ansRight = n;

        // 初始化left = 0,统计s中么个字母出现的次数countS,遍历s
        int left = 0;
        int[] countS = new int[128];
        char[] charS = s.toCharArray();
        for (int right = 0; right < n; right++) {
            ++countS[charS[right]];

            // 遍历countS中t相关字母出现次数,如果出现次数都大于等于countT中出现的次数
            while (right - left + 1 >= t.length() && check(t, countT, countS)) {

                // 如果right - left < ansRight - ansLeft 记录答案
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }

                // left向右移动
                --countS[charS[left]];
                left++;
            }
        }

        if (ansLeft < 0) return ans;

        return s.substring(ansLeft, ansRight+1);
    }

    public boolean check(String t, int[] countT, int[] countS) {
        boolean flag = true;
        for (char c : t.toCharArray()) {
            if (countS[c] < countT[c]) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution_4 solution = new Solution_4();
        System.out.println(solution.minWindow(s, t));
    }
}
