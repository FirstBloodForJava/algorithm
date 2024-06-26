package com.oycm.algorithm.cc;

public class Solution_4 {

    /**
     * 76.最小覆盖子串：https://leetcode.cn/problems/minimum-window-substring/
     * 时间复杂度O(52s + t)
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
            boolean checkFlag = true;
            while (right - left + 1 >= t.length() && checkFlag && check(t, countT, countS)) {

                // 如果right - left < ansRight - ansLeft 记录答案
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }

                // left向右移动
                --countS[charS[left]];
                if (countS[charS[left]] < countT[charS[left]]) {
                    checkFlag = false;
                }
                left++;
            }
        }

        if (ansLeft < 0) return ans;

        return s.substring(ansLeft, ansRight+1);
    }

    public boolean check(String t, int[] countT, int[] countS) {

        for (int i = 'A'; i <= 'Z'; i++) {
            if (countS[i] < countT[i]) {
                return false;
            }
        }

        for (int i = 'a'; i <= 'z'; i++) {
            if (countS[i] < countT[i]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 优化时间复杂度为O(t + s)
     * @param s
     * @param t
     * @return
     */
    public String optimizeMinWindow(String s, String t) {
        int n = s.length();
        String ans = "";
        if (n < t.length()) {
            return ans;
        }
        // 1.统计t中每个字母出现的次数countT
        int[] countT = new int[128];

        // 将t中不同字母的数量记为count
        int count = 0;
        for (char c : t.toCharArray()) {
            ++countT[c];
            if (countT[c] == 1) count++;
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
            // 当遍历的s中的t的字母数量相等时,count--
            if (countS[charS[right]] == countT[charS[right]]) count--;
            // 遍历countS中t相关字母出现次数,如果出现次数都大于等于countT中出现的次数

            // count == 0,代表是符合要求了,这时left可以右移
            while (count == 0) {

                // 如果right - left < ansRight - ansLeft 记录答案
                if (right - left < ansRight - ansLeft) {
                    ansLeft = left;
                    ansRight = right;
                }
                // 在减少当前左边字符时,如果字母数量相同,删除这个字母则会导致不匹配,所有count要+1
                if (countS[charS[left]] <= countT[charS[left]]) count++;
                // left向右移动
                --countS[charS[left]];
                left++;
            }
        }

        if (ansLeft < 0) return ans;

        return s.substring(ansLeft, ansRight+1);
    }

    public static void main(String[] args) {
        String s = "ADOBECODEBANC";
        String t = "ABC";
        Solution_4 solution = new Solution_4();
        System.out.println(solution.minWindow(s, t));
        System.out.println(solution.optimizeMinWindow(s, t));

        System.out.println((int)'a');
        System.out.println((int)'Z');
    }
}
