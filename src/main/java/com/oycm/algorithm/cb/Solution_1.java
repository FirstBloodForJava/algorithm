package com.oycm.algorithm.cb;

import java.util.HashMap;
import java.util.Map;

public class Solution_1 {

    /**
     * 3.无重复字符的最长子串：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
     * @param s
     * @return 字符串不含重复字符的最长字串长度
     */
    public int lengthOfLongestSubstring(String s) {
        int ans = 0;

        Map<Character, Integer> temp = new HashMap<>();
        char[] chars = s.toCharArray();
        int left = 0;
        for (int right = 0; right < chars.length; right++) {

            // 记录从左到有，字符出现的次数
            if (temp.containsKey(chars[right])) {
                temp.put(chars[right], temp.get(chars[right]) + 1);
            }else {
                temp.put(chars[right], 1);
            }
            // 代表有重复字符出现
            while (temp.get(chars[right]) > 1) {
                // 标志为删除
                temp.put(chars[left], temp.get(chars[left]) - 1);
                left++;
            }
            // 计算答案 上一个字符出现的位置left到right就是没有重复元素的
            ans = Math.max(ans, right - left + 1);

        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_1 solution = new Solution_1();
        String s = "abbbbba";
        System.out.println(solution.lengthOfLongestSubstring(s));

    }
}
