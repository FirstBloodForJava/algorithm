package com.oycm.algorithm.db;

/**
 * @author ouyangcm
 * create 2024/6/19 15:07
 */
public class Solution_1_275 {

    /**
     * 275.H指数 II: https://leetcode.cn/problems/h-index-ii/
     * h指数: n篇论文中至少有h篇论文分别被引用了至少h次
     * @param citations 整数升序数组,citations[i]表示第i篇论文被引用的次数; eg: {0,1,3,5,6}
     * @return h指数; eg: 3
     */
    public int hIndex(int[] citations) {
        int ans = 0;

        int left = 0;
        int right = citations.length;
        // h指数随着h(论文篇数)增加是非递增的,h范围[0,n]
        while (left < right) {
            int mid = left + (right - left) / 2;
            // 引用次数 >= 论文数量
            if (citations[mid] >= citations.length - mid) {
                ans = mid;
                right = mid;
            }else {
                left = mid + 1;
            }
        }


        return left == citations.length ? 0 : citations.length - ans;
    }

    public static void main(String[] args) {
        int[] citations = {0};
        Solution_1_275 solution = new Solution_1_275();
        System.out.println(solution.hIndex(citations));
    }
}
