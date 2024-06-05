package com.oycm.algorithm.cc;

/**
 * @author ouyangcm
 * create 2024/6/4 13:57
 */
public class Solution_2 {

    /**
     * 平衡字符串：只含有Q、W、E、R四种字符，且长度为n，在该字符串中，四个字符恰好出现n/4次，那么它就是一个平衡字符串。
     * 1234.替换子串得到平衡字符串：https://leetcode.cn/problems/replace-the-substring-for-balanced-string/
     * @param s s.length是4的倍数，s中只有Q、W、E、R
     * @return 替换s的子串，使得s是一个平衡字符串，返回最小的可能长度，为平衡字符串，则返回0
     */
    public int balancedString(String s) {

        return method(s);
    }

    /**
     * 如果待替换字串之外的任意字符出现次数超过m=n/4,那么无论怎么替换都不能使这个字符在整个字符串中出现次数为m,例如：QQWW QQ WW
     * 如果在待替换的字串之外的任意字符的出现次数都不超过m，那么可以通过替换，使s为平衡字符串
     * 设字串的左右端点为left和right，枚举right，如果字串外的任意字符的出现次数都不超过m，则说明left到right的这段是可替换子串
     * @param s
     * @return
     */
    private int method(String s) {
        int n = s.length();
        int m = n / 4;
        int[] temp = new int['X'];
        char[] chars = s.toCharArray();

        for (char c : chars) {
            ++temp[c];
        }
        if (temp['Q'] == m && temp['W'] == m && temp['E'] == m && temp['R'] == m) {
            // 已经是平衡字符串
            return 0;
        }

        int ans = n;
        int left = 0;
        for (int right = 0; right < n; right++) {
            // 待替换任意字符串出现次数超过m，需要right不断右移，直到不超过
            --temp[chars[right]];
            while (temp['Q'] <= m && temp['W'] <= m && temp['E'] <= m && temp['R'] <= m) {
                ans = Math.min(ans, right - left + 1);
                ++temp[chars[left++]];
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        System.out.println(solution.method("Q"));
    }
}
