package com.oycm.algorithm.cb;

/**
 * @author ouyangcm
 * create 2024/6/4 10:36
 */
public class Solution_3 {

    /**
     * 半重复的：至多有一对的
     * 2730.找到最长的半重复子字符串：https://leetcode.cn/problems/find-the-longest-semi-repetitive-substring/
     * @param s
     * @return
     */
    public int longestSemiRepetitiveSubstring(String s) {
        int ans = 1;
        // 相邻一对字符串，叫相对是一个分界线，mid 当mid==2时，左边的长度固定了，找右边再次出现mid==2的情况，这个时候left=right，right=0
        // 这里的关键是表达式如何转移？
        // 思路转换：移动右指针，并统计相邻相同情况出现了多少次，记为mid
        // 如果same > 1，不断移动左指针，直到s[left] == s[left-1]，此时左边的窗口就可以去掉了这时的记录同mid==1或mid==0
        int left = 0;
        int mid = 0;
        char[] chars = s.toCharArray();
        for (int right = 1; right < s.length(); right++) {
            mid += chars[right-1] == chars[right] ? 1 : 0;

            // 出现两对相同字符
            if (mid > 1) {
                while (mid > 1) {
                    left++;
                    if (chars[left] == chars[left-1]) {
                        mid = 1;
                    }
                }
            }
            // 在mid==1或mid==0时记录答案，如果mid=2则去掉
            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_3 solution = new Solution_3();
        String s = "090112345678900";
        System.out.println(solution.longestSemiRepetitiveSubstring(s));

    }
}
