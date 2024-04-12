package com.oycm.algorithm.c;

import java.util.HashMap;
import java.util.Map;

/**
 * @author ouyangcm
 * create 2024/4/12 9:05
 */
public class Solution_3 {

    public static void main(String[] args) {
        String s = "abcdaefg";
        Solution_3 solution = new Solution_3();
        System.out.println(solution.lengthOfLongestSubstring(s));
    }

    /**
     *
     * @param s 由英文字母、数字、符号和空格组成的字符串
     * @return 无重复字符子串的最长长度
     */
    public int lengthOfLongestSubstring(String s) {

        return method_1(s);
    }

    /**
     * abcdefg..a
     * 对于端点left到right点，都没有字符重复，right+1和前面left-right之间的任一字符重复，记为temp，则前面left端点到temp端点的任意连续字符串都会小于right-left+1长度
     * 这个时候将[left,temp]区间的元素删除,left为temp+1,将right+1添加进map,length为剩余map中的元素个数
     * @param s
     * @return
     */
    public int method_1(String s) {
        int result = 0;
        // 用来判断是否存在重复字符
        Map<Character,Integer> map = new HashMap<>();
        char[] charArray = s.toCharArray();

        int length = 0;
        int left = 0;
        for (int right = 0; right < charArray.length; right++) {
            if (!map.containsKey(charArray[right])) {
                map.put(charArray[right], right);
                length++;
            }else {
                result = Math.max(result, length);
                // 将temp之前的元素删除
                while (map.get(charArray[right]) != null && left <= map.get(charArray[right])){
                    map.remove(charArray[left]);
                    left++;
                }
                // 移除之后重新计算当前剩余长度
                map.put(charArray[right], right);
                length = map.size();
            }
        }

        return Math.max(result, length);
    }
}
