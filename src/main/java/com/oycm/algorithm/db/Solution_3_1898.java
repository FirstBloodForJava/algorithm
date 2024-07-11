package com.oycm.algorithm.db;

/**
 * @author ouyangcm
 * create 2024/6/19 15:35
 */
public class Solution_3_1898 {

    /**
     * 1898.可移除字符的最大数目: https://leetcode.cn/problems/maximum-number-of-removable-characters/
     * 对于removable的前k个下标(0<=i<k<s.length)删除每个s[removable[i]]后，p仍然是s的子序列
     * @param s 字符串; eg: abcacb
     * @param p 字符串, p是s的一个子序列(原字符串中删除或不删除得到的字符串,相对顺序没有改变); eg: ab
     * @param removable 整数数组,元素互不相同; eg: {3,1,0}
     * @return 2
     */
    public int maximumRemovals(String s, String p, int[] removable) {
        int left = 0;
        int right = removable.length + 1;
        char[] chars = s.toCharArray();
        char[] charP = p.toCharArray();
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkSubsequence(chars, charP, removable, mid)) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return left - 1;
    }

    public boolean checkSubsequence(char[] s, char[] p, int[] removable, int k) {
        // true表示删除s[i]
        boolean[] state = new boolean[s.length];
        for (int i = 0; i < k; i++) {
            state[removable[i]] = true;
        }
        int j = 0;
        for (int i = 0; i < s.length; i++) {
            if (!state[i] && s[i] == p[j]) {
                j++;
            }
            if (j == p.length) return true;
        }
        
        return false;
    }

    public static void main(String[] args) {
        String s = "qlevcvgzfpryiqlwy";
        String p = "qlecfqlw";
        int[] removable = {12,5};
        Solution_3_1898 solution = new Solution_3_1898();
        System.out.println(solution.maximumRemovals(s, p, removable));
    }
}
