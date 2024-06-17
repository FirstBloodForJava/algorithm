package com.oycm.algorithm.d;

public class Solution_4_744 {

    /**
     * 744.寻找比目标字母大的最小字母: https://leetcode.cn/problems/find-smallest-letter-greater-than-target/description/
     * @param letters 字符数组,非递减顺序排序,至少两个不同的字符
     * @param target 目标字符
     * @return 大于target的最小字符,不存在则返回第一个字符串
     */
    public char nextGreatestLetter(char[] letters, char target) {

        int left = 0;
        int right = letters.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }

        return right == letters.length ? letters[0] : letters[right];
    }

    public static void main(String[] args) {
        char[] letters = {'c','f','j'};
        char target = 'z';
        Solution_4_744 solution = new Solution_4_744();
        System.out.println(solution.nextGreatestLetter(letters, target));
    }
}
